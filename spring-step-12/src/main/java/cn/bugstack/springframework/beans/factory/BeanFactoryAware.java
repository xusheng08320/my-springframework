package cn.bugstack.springframework.beans.factory;

/**
 * @Author xusheng
 * @Date 2022/12/1 18:19
 * @Desc
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
