package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author xusheng
 * @Date 2022/12/1 17:32
 * @Desc
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
