package cn.bugstack.springframework.context;

import java.util.EventListener;

/**
 * @Author xusheng
 * @Date 2022/11/30 15:36
 * @Desc
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
