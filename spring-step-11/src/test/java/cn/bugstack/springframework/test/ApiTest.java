package cn.bugstack.springframework.test;

import cn.bugstack.springframework.aop.AdvisedSupport;
import cn.bugstack.springframework.aop.TargetSource;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.bugstack.springframework.aop.framework.Cglib2AopProxy;
import cn.bugstack.springframework.aop.framework.JdkDynamicAopProxy;
import cn.bugstack.springframework.beans.factory.PropertyValue;
import cn.bugstack.springframework.beans.factory.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanReference;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.aop.AopServiceImpl;
import cn.bugstack.springframework.test.aop.AopServiceInterceptor;
import cn.bugstack.springframework.test.aop.IAopService;
import cn.bugstack.springframework.test.bean.UserDao;
import cn.bugstack.springframework.test.bean.UserService;
import cn.bugstack.springframework.test.event.CustomEvent;
import org.junit.Test;

import javax.xml.transform.Source;
import java.lang.reflect.Method;

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

    @Test
    public void testApplicationEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void testAspectj() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.bean.UserService.*(..))");
        boolean matchesClass = pointcut.matches(UserService.class);
        System.out.println(matchesClass);
        Method queryUserInfo = UserService.class.getDeclaredMethod("queryUserInfo");
        System.out.println(pointcut.matches(queryUserInfo, UserService.class));
    }

    @Test
    public void testDynamic() {
        IAopService aopService = new AopServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(aopService));
        advisedSupport.setMethodInterceptor(new AopServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.bugstack.springframework.test.aop.IAopService.*(..))"));

        IAopService jdkProxy = (IAopService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        jdkProxy.testAop();

        IAopService cglibProxy = (IAopService) new Cglib2AopProxy(advisedSupport).getProxy();
        cglibProxy.testAop();
    }
}
