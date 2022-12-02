package cn.bugstack.springframework.test.aop;

import cn.bugstack.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author xusheng
 * @Date 2022/12/1 18:45
 * @Desc
 */
public class AopServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
