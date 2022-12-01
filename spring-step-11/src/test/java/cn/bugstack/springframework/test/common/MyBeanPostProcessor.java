package cn.bugstack.springframework.test.common;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author xusheng
 * @Date 2022/11/24 16:22
 * @Desc
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " :postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " :postProcessAfterInitialization");
        return bean;
    }
}
