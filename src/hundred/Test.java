package hundred;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Test {
    public static String get(String a){
        String param="code=1&state=2";
        String p=param.substring (param.indexOf (a)+1);
        return "222";
    }
    public static void main(String[] args) {
//        ExecutorService executorService= Executors.newFixedThreadPool(2);
//        List<People> people=new ArrayList<>();
//        for (int i=0;i<1000;i++){people.add(new People()); }
//        people.parallelStream().forEach(e->executorService.execute(()->{e.run(); }));
        String s="aaa";
        System.out.println ();
        Stream<Double> s1=Stream.generate (Math::random);
    }
}
