package weishi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NuctechUtils {
    public static void main(String[] args) {
        List<Nuctech> list = null;
        try {
            list = util ("C:\\Users\\zxd\\Desktop\\威视相关\\迭代1\\t.csv");
//            list1 = util ("C:\\Users\\zxd\\Desktop\\迭代1\\valid.csv");
//            System.out.println (list1.size ());
        } catch (Exception e) {
            e.printStackTrace ();
        }
        List<Nuctech> list1=new ArrayList<> ();
        if(list!=null){
            list1=util1 (list,"EA");
            List<Nuctech> l1=util1(list,"EB");
            List<Nuctech> l2=util1(list,"EC");
            int a=1261/10*7-list1.size ();
            int b=l1.size ();
            int c=l2.size ();
            double d=(b*1.0/(b+c));
            int e=(int)(a*d);
            List<Nuctech> list2=l1.stream ()
                    .limit (e)
                    .collect(Collectors.toList());
            List<Nuctech> list3=l2.stream ()
                    .limit (a-e)
                    .collect(Collectors.toList());
            list1.addAll (list2);
            list1.addAll (list3);
        }
//            for (Nuctech n : list) {
//                int a = 0;
//                Nuctech k = null;
//                for (Nuctech m : list1) {
//                    if (n.getName ().equals (m.getName ())) {
//                        a++;
//                        k=m;
//                    }
//                }
//                if (a == 0) {
////                    list2.add (n);
//                } else {
//                    list2.add (n);
//                }
//            }
        list.removeAll (list1);
        System.out.println (list.size ());
        System.out.println (list1.size ());
        JavaCore.util (list1, "C:\\Users\\zxd\\Desktop\\train.csv");
        JavaCore.util (list, "C:\\Users\\zxd\\Desktop\\valid.csv");

    }
    public static List<Nuctech> util1(List<Nuctech> list,String str){
        return list.stream ()
                .filter (e->str.equals (e.getName ().substring (0,2)))
                .collect(Collectors.toList());
    }
    public static List<Nuctech> util(String file)throws Exception{
        List<Nuctech> list=new ArrayList<> ();
        FileReader f1 = new FileReader(file);
        BufferedReader b1 = new BufferedReader(f1);
        String str;
        while((str=b1.readLine ())!=null){
            String [] ss=str.split (",");
            Nuctech nuctech=new Nuctech ();
            if(ss.length!=1){
                nuctech.setName (ss[0]);
                nuctech.setX (ss[1]);
                nuctech.setY (ss[2]);
                nuctech.setD (ss[3]);
            }else {
                nuctech.setName (ss[0]);
            }
            list.add (nuctech);
        }
        f1.close ();
        b1.close ();
        return list;
    }
}
