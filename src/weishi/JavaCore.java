package weishi;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaCore {
    public static void main(String[] args) {
        Set<Integer> set =new HashSet<> ();
        while(true){
            int s=(int)(Math.random ()*1261);
            set.add (s);
            int l=set.size ();
            if(l>=1261/10*3) {
                break;
            }
        }
        List<Integer> list= Stream.iterate (0, n->n+1).limit (1261).collect(Collectors.toList ());
        list.removeAll (set);
        List<Nuctech> list1=null;
        try {
            list1=NuctechUtils.util ("C:\\Users\\zxd\\Desktop\\迭代1\\t.csv");
            System.out.println (list1.stream ().distinct ().collect (Collectors.toList ()).size ());
        } catch (Exception e) {
            e.printStackTrace ();
        }
        List<Nuctech> l1=new ArrayList<> ();
        List<Nuctech> l2=new ArrayList<> ();
        for(Integer i:set) l1.add (list1.get (i));
        for(Integer i:list) l2.add (list1.get (i));
        System.out.println (l1.size ());
        System.out.println (l2.size ());
        List<String> l3=l1.stream ().distinct ().map (Nuctech::getName).sorted (String::compareTo).collect(Collectors.toList());
        List<String> l4=l2.stream ().distinct ().map (Nuctech::getName).sorted (String::compareTo).collect(Collectors.toList());
        System.out.println (l3.size ());
        System.out.println (l4.size ());
        util (l2.stream ().distinct ().sorted (Nuctech::compareTo).collect(Collectors.toList()), "C:\\Users\\zxd\\Desktop\\迭代1\\train.csv");
        util (l1.stream ().distinct ().sorted (Nuctech::compareTo).collect(Collectors.toList()),"C:\\Users\\zxd\\Desktop\\迭代1\\valid.csv");
        util (l4,"C:\\Users\\zxd\\Desktop\\迭代1\\train.txt");
        util (l3,"C:\\Users\\zxd\\Desktop\\迭代1\\valid.txt");
    }
    public static void util(Collection c, String file){
        try {
            FileWriter fr=new FileWriter (new File (file));
            c.forEach (e->{
                String k=e+"\r\n";
                try {
                    fr.write (k);
                } catch (IOException ex) {
                    ex.printStackTrace ();
                }
            });
            fr.flush ();
            fr.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}

