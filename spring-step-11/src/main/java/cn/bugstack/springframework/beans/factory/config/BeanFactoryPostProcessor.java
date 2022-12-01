package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author xusheng
 * @Date 2022/11/24 14:34
 * @Desc
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
