package java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * 觉得好玩嘛
 */
public class Demo1 {
    public static void main(String[] args) {
        Apple a1 = new Apple (5, "red");
        Apple a2 = new Apple (3, "red");
        Apple a3 = new Apple (10, "green");
        Apple a4 = new Apple (1, "green");
        //Apple 列表
        List<Apple> list = Arrays.asList (a1, a2, a3, a4);
        //筛选
        Map<String, Map<Boolean, List<Apple>>> map = list.stream ().collect (Collectors.groupingBy (Apple::getColor, Collectors.groupingBy (e -> {
            return e.getWeight () > 4;
        })));
        System.out.println (map);
//        Predicate<Apple> predicate=(Apple a)->a.getWeight ();//Bad return type in lambda expression: Integer cannot be converted to boolean

        Predicate<Apple> predicate=(a->a.islight ());
        //方法引用
        Predicate<Apple> predicate1=Apple::islight;
        IntToDoubleFunction i=s->s*1.0;
        list.stream ().peek (System.out::println).collect (Collectors.toList ());
    }
}
class MyPredicate implements Predicate<Apple>{
    @Override
    public boolean test(Apple apple) {
        if (apple.islight ()){
            return true;
        }
        return false;
    }
}

class Apple{

    private Integer weight;
    private String color;
    public Apple(Integer weight,String color){
        this.weight=weight;
        this.color=color;
    }

    public Apple(Integer weight) {
        this.weight=weight;
    }

    public Integer getWeight(){
        return this.weight;
    }
    public void setWeight(Integer weight) { this.weight = weight; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean islight(){
        if(this.getWeight ()>4){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

