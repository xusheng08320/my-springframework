package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition bd = new BeanDefinition(UserService.class);

        beanFactory.registerBeanDefinition("userService", bd);

        UserService userService = (UserService) beanFactory.getBean("userService", "test");
        userService.queryUserInfo();
        System.out.println(userService);
    }
}
