package cn.bugstack.springframework.beans.factory.config;

public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class bean) {
        this.beanClass = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
