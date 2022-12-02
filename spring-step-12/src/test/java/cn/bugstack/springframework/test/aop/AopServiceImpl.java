package cn.bugstack.springframework.test.aop;

/**
 * @Author xusheng
 * @Date 2022/12/1 16:13
 * @Desc
 */
public class AopServiceImpl implements IAopService{
    @Override
    public void testAop() {
        System.out.println("testAop");
    }
}
