package java8;



import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

/**
 * 方法引用
 */
public class Demo2 {
    public static void main(String[] args) {
        //字符串转数字
        Function<String,Integer> stringIntegerFunction=Integer::parseInt;
        System.out.println(stringIntegerFunction.apply("3"));
        //创建对象
        Function<Integer,Apple> function=Apple::new;//e->{return new Apple (e);};
        List<Integer> weights= Arrays.asList(2,3,5,6,7,8);
        List<Apple> apples=weights.parallelStream().map(e->function.apply(e)).collect(Collectors.toList());
        System.out.println(apples);
        //比较器复合
        BiFunction<Integer,String,Human> biFunction=Human::new;
        List<String> names=Arrays.asList("我","你","她","他","它","他");
        Map<Integer,String> map=new HashMap<>();
        for (int i=0;i<names.size();i++){
            map.put(weights.get(i),names.get(i));
        }
        List<Human> humanList=new ArrayList<>();
        map.forEach((key,value)->{
            humanList.add(biFunction.apply(key,value));
        });
        //根据name排序
        humanList.sort(comparing(Human::getName));
        System.out.println(humanList);
        //根据name排序倒序
        humanList.sort(comparing(Human::getName).reversed());
        System.out.println(humanList);
        //根据id和姓名排序
        humanList.sort(comparing(Human::getId).thenComparing(Human::getName));
        System.out.println(humanList);
        //谓词复合negate\or\and
        //过滤器：根据Human内的boolean型方法过滤
        Predicate<Human> predicate=Human::bigfor;
        //过滤小于3的
        List<Human> humanList1= humanList.parallelStream().filter(predicate).collect(Collectors.toList());
        //过滤不是小于3的
        List<Human> humanList2= humanList.parallelStream().filter(predicate.negate()).collect(Collectors.toList());
        System.out.println(humanList1);
        System.out.println(humanList2);
        //过滤器：根据Human内的boolean型方法过滤
        Predicate<Human> predicate1=Human::isGirl;
        //大于3且name="她"
        List<Human> humanList3=humanList.parallelStream().filter(predicate.and(predicate1)).collect(Collectors.toList());
        System.out.println(humanList3);
        //小于3或name="她"
        List<Human> humanList4=humanList.parallelStream().filter(predicate.negate().or(predicate1)).collect(Collectors.toList());
        System.out.println(humanList4);
        //流来筛选比3大的Human的前2哥的名字
        long page=3;
        long size=1;
        page=(page-1)*size;
        List<String> stringList=humanList.stream().filter(Human::bigfor).map(Human::getName).skip(page).limit(size).collect(Collectors.toList());
        System.out.println(stringList);

        Human human=new Human (1,"zm");
        Human human1=new Human (2,"zm");
        Human human2=new Human (1,"zd");
        List<Human> list=Arrays.asList (human,human1,human2);
        List<Integer> list1=new ArrayList<> ();

//        list.parallelStream ().collect (groupingBy (Human::getName)).forEach ((k, v)->{
//            list1.add (v.size ());
//        });
//        List<Double> list2=list.parallelStream ().map (e->{
//           return (double)e.getId ();
//        }).collect(Collectors.toList());

//        System.out.println (list2);
//        List<Integer> list3=Arrays.asList (0,7,9,9,9,9,9,9,9,9,9,9);
//        List<List<Integer>> list5=new ArrayList<> ();
//        List<Integer> list4=Arrays.asList (0,0,0,0,0,0,0,0,0,0,0);
//       list3.stream ().forEach (e->{
//          for (int i=0;i<22;i+=2){
//             if(e>=i&&e<i+2){
//                 if(Arrays.asList (i,i+2,e)!=null){
//                     list5.add (Arrays.asList (i,i+2,e));
//                     break;
//                 }
//             }
//          }
//       });
//        List<List<Integer>> lists=new ArrayList<> ();
//       list5.stream ().collect (Collectors.groupingBy (e->e.get (0))).forEach ((k,v)->{
//                   lists.add (Arrays.asList (k,k+2,v.size ()));
//       });
//       List<Integer> list6=lists.stream ().map (e->{return e.get (0);}).collect(Collectors.toList());
//        System.out.println (list6);
//       for(int i=0;i<22;i+=2){
//           if(! list6.contains (i)){
//               lists.add (Arrays.asList (i,i+2,0));
//           }
//       }
//        System.out.println (lists);


}
}
class Human{
    private Integer id;
    private String name;
    public Human(Integer id,String name){
        this.id=id;
        this.name=name;
    }
    public boolean bigfor(){
        return this.id>3;
    }
    public boolean isGirl(){
        return "她".equals(this.name);
    }
    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
