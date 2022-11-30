package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.context.ApplicationEvent;
import cn.bugstack.springframework.context.ApplicationListener;

/**
 * @Author xusheng
 * @Date 2022/11/30 17:26
 * @Desc
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.getId());
        System.out.println(event.getMessage());
    }
}
