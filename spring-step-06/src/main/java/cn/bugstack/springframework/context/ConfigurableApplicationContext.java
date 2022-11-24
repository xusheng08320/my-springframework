package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.BeansException;

/**
 * @Author xusheng
 * @Date 2022/11/24 14:20
 * @Desc
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
