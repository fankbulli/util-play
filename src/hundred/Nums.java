package hundred;

public class Nums{
    public static int num=100;
    public static Nums nums=null;
    public static Nums getInstance(){

      synchronized (Nums.class){
          if(nums==null){
            nums= new Nums();
        }
      }
        return nums;
    }
    public synchronized String relese(){
        if(num!=0){
            num--;
            return num+"success";
        }
        return num+"error";
    }
}
