package cn.bugstack.springframework.beans.factory.support;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingleBeanRegistry {
    private Map<String, Object> singletonObject = new ConcurrentHashMap<String, Object>();

    public Object getSingleton(String name) {
        return singletonObject.get(name);
    }

    public void registerSingle(String beanName, Object object) {
        singletonObject.put(beanName, object);
    }
}
