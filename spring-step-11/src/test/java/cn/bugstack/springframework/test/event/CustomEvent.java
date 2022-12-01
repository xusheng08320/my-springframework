package cn.bugstack.springframework.test.event;

import cn.bugstack.springframework.context.ApplicationEvent;

/**
 * @Author xusheng
 * @Date 2022/11/30 17:25
 * @Desc
 */
public class CustomEvent extends ApplicationEvent {

    private Long id;

    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
