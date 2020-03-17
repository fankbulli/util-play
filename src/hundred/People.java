package hundred;

public class People implements Runnable{
    @Override
    public void run() {
         Nums nums=Nums.getInstance();
         if(Nums.num>0){
             System.out.println(nums.relese());
         }else {
             return;
         }
    }
}
