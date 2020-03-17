package example;

public class Demo1 {
    private String a="sss";

    public void getA(){
        System.out.println (a);
    }
}
class Demo2 extends Demo1{
    Demo1 d=new Demo2 ();
    public void say(){
        d.getA ();
    }
}
class Demo3{
    public static void main(String[] args) {
        Demo2 d=new Demo2 ();
        d.getA ();
    }
}