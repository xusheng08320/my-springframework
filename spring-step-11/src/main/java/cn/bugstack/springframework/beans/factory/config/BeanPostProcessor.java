package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.BeansException;

/**
 * @Author xusheng
 * @Date 2022/11/24 14:40
 * @Desc
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
