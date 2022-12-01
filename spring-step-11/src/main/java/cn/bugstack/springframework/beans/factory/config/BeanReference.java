package cn.bugstack.springframework.beans.factory.config;

/**
 * @Author xusheng
 * @Date 2022/11/22 15:08
 * @Desc
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
