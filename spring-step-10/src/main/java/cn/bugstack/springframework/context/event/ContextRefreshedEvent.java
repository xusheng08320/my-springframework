package cn.bugstack.springframework.context.event;

/**
 * @Author xusheng
 * @Date 2022/11/29 16:23
 * @Desc
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
