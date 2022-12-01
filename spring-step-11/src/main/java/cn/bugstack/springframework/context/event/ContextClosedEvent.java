package cn.bugstack.springframework.context.event;

/**
 * @Author xusheng
 * @Date 2022/11/29 16:22
 * @Desc
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
