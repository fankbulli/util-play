package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class finalOpera {
    public static void main(String[] args) {
        System.out.println ("最终输出:");
        List<Integer> integers=Arrays.asList (1,3,5,6,7,8,9,7,6,5,4,10,3,7,7);
        boolean i1=integers.stream ().anyMatch (e->e==2);
        System.out.println ("是否有元素=2："+i1);
        boolean i2=integers.stream ().noneMatch (e->e<0);
        System.out.println ("是否没有元素<0："+i2);
        boolean i3=integers.stream ().allMatch (e->e>2);
        System.out.println ("是否所有元素>2："+i3);
        Optional<Integer> o1=integers.stream ().findFirst ();
        System.out.println ("返回流得第一个："+o1.orElse (0));


        Optional<Integer> o2=integers.stream ().findAny ();
        System.out.println ("串行时返回第一个并行时返回最先匹配得一个："+o2.orElse (0));
        int sum=integers.stream ().reduce (0,(e1,e2)->e1+e2);
        Optional<Integer> o3=integers.stream ().reduce ((e1,e2)->e1+e2);
        System.out.println ("当有起始值时返回一个int,没起始值时返回一个Optional"+sum+"<==>"+o3.orElse (0));
        Arrays.asList (1,3,5,6,7,8,9,7,6,5,4,10,3,7,7)
                .stream ()                          //创建流
                .filter (e->e>4)                    //得到大于4得元素
                .distinct ()                        //去重
                .sorted (Integer::compareTo)        //升序排序
                .skip (2)                           //跳过前两个元素
                .limit (4)                          //截取四个元素
                .map (e->e*e)                       //获得每个元素得平方
                .forEach (System.out::println);  //依次输出最终流中得元素
    }
}


