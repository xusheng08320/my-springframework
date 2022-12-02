package cn.bugstack.springframework.context;

import java.util.EventObject;

/**
 * @Author xusheng
 * @Date 2022/11/29 16:18
 * @Desc
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
