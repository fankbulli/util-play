package java8;


public class LambdaDemo {
    public static void main(String[] args) {
        //old
       process (new Runnable () {
           @Override
           public void run() {
               System.out.println ("This is old");
           }
       });
       //new
        process (()-> System.out.println ("This is new "));
    }
    public static void process(Runnable r){
        r.run ();
    }
}
