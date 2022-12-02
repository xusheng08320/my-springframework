package cn.bugstack.springframework.beans.factory;

import java.util.concurrent.ExecutionException;

/**
 * @Author xusheng
 * @Date 2022/11/25 13:24
 * @Desc
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
