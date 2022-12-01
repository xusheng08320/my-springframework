package cn.bugstack.springframework.aop;

/**
 * @Author xusheng
 * @Date 2022/12/1 15:37
 * @Desc
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
