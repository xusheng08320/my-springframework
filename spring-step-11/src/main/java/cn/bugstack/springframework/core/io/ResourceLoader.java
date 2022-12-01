package cn.bugstack.springframework.core.io;

/**
 * @Author xusheng
 * @Date 2022/11/22 17:16
 * @Desc
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
