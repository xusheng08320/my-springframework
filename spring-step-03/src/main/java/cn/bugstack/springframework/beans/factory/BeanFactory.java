package cn.bugstack.springframework.beans.factory;

public interface BeanFactory {
    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;
}
