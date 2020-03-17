package java8;

import com.sun.javaws.exceptions.InvalidJarDiffException;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Demo4 {

    public static Map<Boolean,List<Integer>> partprimes(int a){
        return IntStream.rangeClosed(2,a).boxed().collect(new PrimesCollectors());
    }
    public static Map<Boolean,List<Integer>> partprimes2(int a){
        return IntStream.rangeClosed(2,a).boxed().collect(partitioningBy(candidate->isPrime(candidate)));
    }
    public static boolean isPrime(int candidata){
        int candidataBoot=(int)Math.sqrt((double) candidata);
        return IntStream.rangeClosed(2,candidataBoot).noneMatch(i->candidata%i==0);
    }
    public static void main(String[] args) {
        long fastset=Long.MAX_VALUE;
        for (int i=0;i<10;i++){
            long start=System.nanoTime();
            partprimes(1_000_000);
            long duration=(System.nanoTime()-start)/1_000_000;
            if(duration<fastset){
                fastset=duration;
            }

    }
        long fastset1=Long.MAX_VALUE;
        for (int i=0;i<10;i++){
            long start=System.nanoTime();
            partprimes2(1_000_000);
            long duration=(System.nanoTime()-start)/1_000_000;
            if(duration<fastset1){
                fastset1=duration;
            }

        }
        System.out.println(fastset);
        System.out.println(fastset1);
    }

}
class PrimesCollectors implements Collector <Integer, Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>>{
    public static boolean isPrime(List<Integer> primes,int candidata){
        int candidataBoot=(int)Math.sqrt((double) candidata);
        return takewhile(primes,i->i<=candidataBoot).stream().noneMatch(p->candidata%p==0);
    }
    public static <A> List<A> takewhile(List<A> list, Predicate<A> p){
        int i=0;
        for (A item:list){
            if(!p.test(item)){
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }
    @Override
    public Supplier<Map<Boolean,List<Integer>>> supplier() {
        return ()->new HashMap<Boolean,List<Integer>>(){
            {
                put(true,new ArrayList<Integer>());
                put(false,new ArrayList<Integer>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean,List<Integer>>,Integer >accumulator() {
        return (Map<Boolean,List<Integer>> acc,Integer candidata)->{
            acc.get(isPrime(acc.get(true),candidata)).add(candidata);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean,List<Integer>>>  combiner() {
        return (Map<Boolean,List<Integer>> map1,Map<Boolean,List<Integer>> map2)->{
            map1.get(true).addAll(map2.get(true));
            map2.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean,List<Integer>>,Map<Boolean,List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }
}
