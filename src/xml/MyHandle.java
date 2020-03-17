package xml;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHandle {
    public static void main(String[] args) {
        File file=new File ("src/xml/user.xml");
        Reader reader;
        List<String> list=new ArrayList<> ();
        try {
            reader=new FileReader (file);
            int c=reader.read ();
            String str="";
            while (c!=-1){
                str+=(char)c;
                if (str.endsWith ("</user>")){
                    list.add (str);
                    str="";
                }
                c=reader.read ();
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }finally {
        }
        List<User> list1=new ArrayList<> ();
        list.stream ().forEach (e->{
            User user=new User ();
            String id=e.substring (e.indexOf ("<id>")+4,e.indexOf ("</id>"));
            String name=e.substring (e.indexOf ("<name>")+6,e.indexOf ("</name>"));
            String sex=e.substring (e.indexOf ("<sex>")+5,e.indexOf ("</sex>"));
            String age=e.substring (e.indexOf ("<age>")+5,e.indexOf ("</age>"));
            user.setId (id);
            user.setName (name);
            user.setSex (sex);
            user.setAge (Integer.parseInt (age));
            list1.add (user);
        });
        list1.forEach (e->{
            System.out.println (e);
        });
    }
}
