package cn.bugstack.springframework.test;

import cn.bugstack.springframework.BeanDefinition;
import cn.bugstack.springframework.BeanFactory;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAnyAttribute;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition bd = new BeanDefinition(new UserService());
        beanFactory.registryBeanDefinition("userService", bd);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
