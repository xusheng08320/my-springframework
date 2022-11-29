package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeansException;

/**
 * @Author xusheng
 * @Date 2022/11/23 14:22
 * @Desc
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeIntialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterIntialization(Object existingBean, String beanName) throws BeansException;
}
