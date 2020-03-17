package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo3 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,5,6,7,7,8);
        List<Integer> list1=list.stream().map(e->e*e).distinct().collect(Collectors.toList());
        System.out.println(list1);
        List<Integer> list2=Arrays.asList(1,2,3);
        List<Integer> list3=Arrays.asList(3,4);
        List<int[]> list4=list.parallelStream().flatMap(e->list3.parallelStream().map(f->new int[]{e,f})).collect(Collectors.toList());
        System.out.println(list4);
        Optional<Integer> min=list.stream().distinct().reduce((a,b)->a>b?b:a);
        Optional<Integer> max=list.stream().distinct().reduce(Integer::max);
        System.out.println(min.get()+"<--->"+max.get());
        //领域：交易员和交易
        Trader raoul=new Trader("raoul","剑桥");
        Trader mario=new Trader("mario","米兰");
        Trader alan=new Trader("alan","剑桥");
        Trader brian=new Trader("brian","剑桥");
        List<Transaction> transactions=Arrays.asList(
          new Transaction(brian,2011,300),
          new Transaction(raoul,2012,1000),
          new Transaction(raoul,2011,400),
          new Transaction(mario,2012,710),
          new Transaction(mario,2012,700),
          new Transaction(alan,2012,950)
        );
        //找出2011年发生的所有交易，并按交易额排序（从低到高）a
        transactions.stream().filter(e->e.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        System.out.println("<======================================================================>");
        //交易员都在哪些不同的城市工作过
        transactions.stream().map(e->e.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("<======================================================================>");
        //查找所有来自剑桥的交易员，按姓名排序
        transactions.stream()
                                       .map(Transaction::getTrader)
                                       .filter(e->e.getCity().equals("剑桥"))
                                       .distinct()
                                       .sorted(Comparator.comparing(Trader::getName))
                                       .forEach(System.out::println);
        System.out.println("<======================================================================>");
        //返回所有交易员的姓名字符串，按字母顺序
        String str=transactions.stream().map(e->e.getTrader().getName()).distinct().sorted().collect(Collectors.joining());
        System.out.println(str);
        System.out.println("<======================================================================>");
        //有没有交易员在米兰工作
        boolean isMilan=transactions.stream().anyMatch(e->e.getTrader().getCity().equals("米兰"));
        System.out.println(isMilan);
        System.out.println("<======================================================================>");
        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(e->e.getTrader().getCity().equals("剑桥")).forEach(System.out::println);
        System.out.println("<======================================================================>");
        //所有交易中，最高的交易额是多少
        Optional<Integer> max1=transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(max1.get());
        System.out.println("<======================================================================>");
        //找到交易额最小的交易
        Optional<Transaction> min1=transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).findFirst();
        System.out.println(min1.get());
        //一百以内质数分区
    }
}
class Trader{
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }
}
