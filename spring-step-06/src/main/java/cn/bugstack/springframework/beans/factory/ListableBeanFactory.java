package cn.bugstack.springframework.beans.factory;

import java.util.Map;

/**
 * @Author xusheng
 * @Date 2022/11/23 14:19
 * @Desc
 */
public interface ListableBeanFactory extends BeanFactory{

    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
