package cn.bugstack.springframework.aop;

/**
 * @Author xusheng
 * @Date 2022/12/1 17:23
 * @Desc
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
