package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.BeansException;

/**
 * @Author xusheng
 * @Date 2022/12/1 18:13
 * @Desc
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
