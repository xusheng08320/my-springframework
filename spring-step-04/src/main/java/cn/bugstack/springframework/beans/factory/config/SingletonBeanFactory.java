package cn.bugstack.springframework.beans.factory.config;

public interface SingletonBeanFactory {

    Object getSingle(String beanName);
}
