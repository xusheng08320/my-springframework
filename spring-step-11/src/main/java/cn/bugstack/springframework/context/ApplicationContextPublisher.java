package cn.bugstack.springframework.context;

/**
 * @Author xusheng
 * @Date 2022/11/30 16:38
 * @Desc
 */
public interface ApplicationContextPublisher {

    void publishEvent(ApplicationEvent event);
}
