package cn.bugstack.springframework.test.bean;

public class UserService {

    private String uId;

    private UserDao userDao;

    public UserService() {
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
