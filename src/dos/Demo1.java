package dos;

import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime ().exec ("ffmpeg -i C:\\Users\\zxd\\qq.mp4 -vframes 30 -y -f gif C:\\Users\\zxd\\a.gif ");
        } catch (IOException e) {
            e.printStackTrace ();
        }
        ;
    }
}
