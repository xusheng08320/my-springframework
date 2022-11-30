package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.context.ApplicationListener;
import cn.bugstack.springframework.context.event.ContextClosedEvent;

/**
 * @Author xusheng
 * @Date 2022/11/30 17:35
 * @Desc
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("容器关闭事件：" + event.getClass().getName());
    }
}
