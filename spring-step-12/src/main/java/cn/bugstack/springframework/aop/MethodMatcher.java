package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author xusheng
 * @Date 2022/12/1 15:14
 * @Desc
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
