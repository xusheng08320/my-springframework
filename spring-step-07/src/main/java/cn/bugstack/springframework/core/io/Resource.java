package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author xusheng
 * @Date 2022/11/22 16:41
 * @Desc
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
