package java8;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.WeakHashMap;

public class Demo5 {
    public static void main(String[] args) {
//        int a=10;
        Runnable r=()->{
//            int a=2; //外面有a的定义   Variable 'a' is already defined in the scope
            System.out.println ("关于this 和super的匿名类问题");
        };
//        doSomething ((Task) ()->System.out.println ("wwww"));//重载方法可以强制类型转换


    }
    interface Task{
        public void execute();
    }
    public static void doSomething(Runnable r){r.run ();};
    public static void doSomething(Task t){t.execute ();};
}
interface VStrategy{
         boolean execute(String s);
}
class IsAllLowerCase implements VStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches ("[a-z]+");
    }
}
class IsNumric implements VStrategy{
    @Override
    public boolean execute(String s) {
        return s.matches ("\\d+");
    }
}
