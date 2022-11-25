package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.*;
import cn.bugstack.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("instantiation for bean failed", e);
        }
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);
        addSingle(beanName, bean);
        return bean;
    }

    private void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        Object wrappedBean = applyBeanPostProcessorsBeforeIntialization(bean, beanName);
        try {
            invokeInitMethod(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("invocation of init method of bean[" + beanName + "] failed", e);
        }
        wrappedBean = applyBeanPostProcessorsAfterIntialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethod(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        if (bean instanceof InitializingBean) {
            ((InitializingBean) bean).afterPropertiesSet();
        }

        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            Method method = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (method == null) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeIntialization(Object existingBean, String beanName) throws BeansException {
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        if (CollectionUtil.isEmpty(beanPostProcessors)) {
            return existingBean;
        }
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterIntialization(Object existingBean, String beanName) throws BeansException {
        List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
        if (CollectionUtil.isEmpty(beanPostProcessors)) {
            return existingBean;
        }
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor2Use = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                constructor2Use = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor2Use, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
