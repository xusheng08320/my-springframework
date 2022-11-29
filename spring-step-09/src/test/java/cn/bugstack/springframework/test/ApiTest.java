package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.factory.PropertyValue;
import cn.bugstack.springframework.beans.factory.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
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

    @Test
    public void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();
        applicationContext.close();
    }

    @Test
    public void testFactoryBean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void testProtytype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService1 == userService);
    }
}
