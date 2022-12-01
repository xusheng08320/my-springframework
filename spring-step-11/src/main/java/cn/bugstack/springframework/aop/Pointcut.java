package cn.bugstack.springframework.aop;

/**
 * @Author xusheng
 * @Date 2022/12/1 15:12
 * @Desc
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
