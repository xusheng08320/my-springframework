package cn.bugstack.springframework.test.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author xusheng
 * @Date 2022/12/1 16:14
 * @Desc
 */
public class AopServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } finally {
            System.out.println("监控开始");
            System.out.println("方法名称：" + methodInvocation.getMethod());
            System.out.println("监控结束");
        }
    }
}
