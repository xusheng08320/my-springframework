package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.HierarchicalBeanFacoty;

/**
 * @Author xusheng
 * @Date 2022/11/23 14:23
 * @Desc
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFacoty, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
