package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        StringBuilder code = new StringBuilder();
        SimpleDateFormat dateFormat=new SimpleDateFormat ("yyyyMMddHHmmss");
        Date date= Calendar.getInstance ().getTime ();
        code.append("WS");
        code.append(dateFormat.format (date));
        System.out.println (dateFormat.format (date));
        code.append (900+(int)(Math.random ()*100));
        System.out.println (code);
        System.out.println (new Date ());
    }
}
