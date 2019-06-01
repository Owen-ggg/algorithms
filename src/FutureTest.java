/*
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

    public static void main(String[] args) {
       */
/* ThreadPoolExecutor executor1 = new ThreadPoolExecutor(6,
                10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());*//*


        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Object> future = new FutureTask<Object>(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                // TODO Auto-generated method stub
                Thread.sleep(5000);
                System.out.println("---------aaaa------------");
                return "aaa";
            }
        });
        executor.execute(future);
        try {
            String result = (String) future.get(5000, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            future.cancel(true);
            executor.shutdown();
        }
    }
}
*/
