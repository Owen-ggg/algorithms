package jdk8features;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Mengjun Wen
 * @date 2018/6/14
 */
public class TestStream {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = integers.stream();
        stream.filter(x-> x%2==0).map(x->x*x).forEach(System.out::println);
        // stream只能使用一次 一次之后重新获取
        Optional<Integer> reduce = stream.filter(x -> x % 2 == 0).map(x -> x * x).reduce(Integer::sum);
        System.out.println(reduce.orElse(0));
    }
}
