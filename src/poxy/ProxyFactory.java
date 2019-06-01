package poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口,但是需要指定接口类型
 */
public class ProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    private boolean tag = false;
    private int count = 0;
    private Object result = null;

    /**
     * 给目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    while (!tag) {
                        count++;
                        FutureTask future = getTask(method, args);
                        // 把任务加入executor
                        executor.execute(future);
                        run(future);
                    }
                    executor.shutdown();
                    return result;
                }
        );
    }

    /**
     * 获取任务对象
     *
     * @param method
     * @param args
     * @return
     */
    public FutureTask getTask(Method method, Object... args) {
        FutureTask<Object> future = new FutureTask<Object>(() -> {
            // TODO Auto-generated method stub
            //运用反射执行目标对象方法
            Object returnValue = method.invoke(target, args);
            return returnValue;
        });
        return future;
    }


    public void run(FutureTask future) {
        try {
            result = future.get(2000, TimeUnit.MILLISECONDS);
            tag = true;
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            System.out.println("time out" + count);
            result = false;
        } finally {
            System.out.println(count);
            future.cancel(true);
        }
    }
}