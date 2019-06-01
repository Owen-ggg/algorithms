package poxy;

/**
 * @author Mengjun Wen
 * @date 2018/7/4
 */
public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        IUserService proxyInstance = (IUserService) new ProxyFactory(userService).getProxyInstance();
        String s = proxyInstance.get();
        System.out.println(s);
    }
}
