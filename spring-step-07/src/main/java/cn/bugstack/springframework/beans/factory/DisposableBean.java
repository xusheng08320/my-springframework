package cn.bugstack.springframework.beans.factory;

/**
 * @Author xusheng
 * @Date 2022/11/25 13:25
 * @Desc
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
