package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xusheng
 * @Date 2022/11/29 13:35
 * @Desc
 */
public class FactoryBeanRegistrySupport extends DefaultSingleBeanRegistry{

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = getCachedObjectForFactoryBean(beanName);
            if (object == null) {
                object = doGetBeanFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != null ? object : null);
        }
        return doGetBeanFromFactoryBean(factoryBean, beanName);
    }

    private Object doGetBeanFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
