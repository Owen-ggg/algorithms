package poxy;

/**
 * @author Mengjun Wen
 * @date 2018/7/4
 */
public class UserServiceImpl implements IUserService {
    int millis = 5000;
    @Override
    public String get() {
        try {
            millis-=1000;
            System.out.println(millis);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
        return "get method run";
    }
}
