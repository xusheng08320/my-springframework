package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.PropertyValue;
import cn.bugstack.springframework.beans.factory.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10001"));
        BeanDefinition userDaoBD = new BeanDefinition(UserDao.class, propertyValues);
        beanFactory.registerBeanDefinition("userDao", userDaoBD);


        PropertyValues userServicePropertyValues = new PropertyValues();
        userServicePropertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition userServiceBD = new BeanDefinition(UserService.class, userServicePropertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBD);

        UserService userService = (UserService) beanFactory.getBean("userService", "test");
        userService.queryUserInfo();
        System.out.println(userService);
    }

    @Test
    public void testXml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
