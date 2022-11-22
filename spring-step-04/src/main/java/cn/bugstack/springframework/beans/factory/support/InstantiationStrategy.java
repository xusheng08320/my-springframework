package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author xusheng
 * @Date 2022/11/22 13:08
 * @Desc
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition bd, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
