package cn.bugstack.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author xusheng
 * @Date 2022/12/1 17:23
 * @Desc
 */
public interface Advisor {

    Advice getAdvice();
}
