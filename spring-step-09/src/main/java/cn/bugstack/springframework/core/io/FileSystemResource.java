package cn.bugstack.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author xusheng
 * @Date 2022/11/22 16:57
 * @Desc
 */
public class FileSystemResource implements Resource {
    private final String path;
    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
