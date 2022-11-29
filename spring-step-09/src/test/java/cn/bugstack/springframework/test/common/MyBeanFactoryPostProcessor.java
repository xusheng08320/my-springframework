package cn.bugstack.springframework.test.common;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.beans.factory.PropertyValue;
import cn.bugstack.springframework.beans.factory.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author xusheng
 * @Date 2022/11/24 16:19
 * @Desc
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userServiceBD = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = userServiceBD.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "修改字段"));

    }
}
