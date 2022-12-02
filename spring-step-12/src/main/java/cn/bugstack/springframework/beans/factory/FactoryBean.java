package cn.bugstack.springframework.beans.factory;

/**
 * @Author xusheng
 * @Date 2022/11/29 13:33
 * @Desc
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
