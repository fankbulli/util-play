package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo7 {
    private static AtomicInteger atomicInt=new AtomicInteger (0);
    private static Integer integer=0;
    public static void main(String[] args) {
        List<Integer> list= IntStream.iterate (0,n->n+1).limit (100).boxed ().collect(Collectors.toList());
        atomicInt.set (0);
        list.parallelStream ().forEach (e->{
            integer+=e;
            atomicInt.updateAndGet (s->s+=e);
        });
        System.out.println (integer);
        System.out.println (atomicInt.get ());
    }
}
