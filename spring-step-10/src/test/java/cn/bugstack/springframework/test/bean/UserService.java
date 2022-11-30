package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.factory.DisposableBean;
import cn.bugstack.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

    private String uId;

    private IUserDao userDao;

    private String company;

    public UserService() {
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy UserService");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet UserService");
    }

    public void init() {
        System.out.println("UserService init");
    }
}
