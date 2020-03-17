package pingan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    public static void main(String[] args) {
        Service service=new Service ();
        System.out.println (service.get ());
    }
    public List<ImageDto> get(){
        //模拟从数据库拿到数据集合
        List<Result> list= Arrays.asList (new Result ("ng"),new Result ("ok"),new Result ("ng"),new Result ("ok"),new Result ("ng"),new Result ("ng"),new Result ("ng"));
        List<ImageDto> list1=new ArrayList<> ();
        list.stream ().collect (Collectors.groupingBy (Result::getLabel)).forEach ((k,v)->{
            ImageDto imageDto=new ImageDto (k,String.valueOf (v.size ()));
            list1.add (imageDto);
        });
        return list1;
    }
}
