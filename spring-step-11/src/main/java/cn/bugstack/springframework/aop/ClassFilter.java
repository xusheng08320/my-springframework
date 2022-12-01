package cn.bugstack.springframework.aop;

/**
 * @Author xusheng
 * @Date 2022/12/1 15:13
 * @Desc
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
