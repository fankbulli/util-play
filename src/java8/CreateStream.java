package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) throws IOException {
        //Stream.of
        Stream<Integer> stream1=Stream.of (1,2,3);
        //Arrays.stream
        IntStream stream2= Arrays.stream (new int[]{1,2,3});
        //文件生成流
        Stream<String> stream3= Files.lines (Paths.get ("file.txt"), Charset.defaultCharset ());
        //有函数生成流
        Stream<Integer> stream4=Stream.iterate (0,n->n+1);
        Stream<Double> stream5=Stream.generate (Math::random);
        //由集合生成
        Arrays.asList (1,2,3).stream ().forEach (System.out::println);
    }
}
