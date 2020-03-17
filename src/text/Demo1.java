package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        long a=3L;
        long b=2L;
       int  d=(int)a;
        double c=(double)a/(double)b;
        System.out.println (d);
        List<Integer> list=Arrays.asList (77, 16, 21, 27, 72, 90, 20, 24, 70, 30, 8, 4, 12, 12, 12, 10, 12, 252, 8, 15,
                8, 12, 8, 12, 15, 10, 72, 8, 6, 36, 15, 66, 14, 266, 12, 288, 160, 10, 15, 390, 15, 12, 115, 18, 10, 20,
                10, 15, 60, 12, 91, 144, 45, 16, 16, 18, 60, 40, 18, 64, 18, 180, 99, 100, 120, 99, 100, 182, 120, 99,
                143, 121, 132, 120, 130, 108, 130, 120, 143, 110, 143, 143, 90, 120, 99, 160, 420, 441, 506, 441, 506,
                484, 441, 575, 420, 112, 112, 84, 65, 105, 72, 120, 198, 110, 108, 99, 108, 108, 100, 120, 100, 121, 120,
                120, 120, 110, 120, 110, 110, 108, 130, 110, 130, 120, 121, 110, 99, 224, 110, 110, 110, 120, 121, 96, 84, 65, 56,
                120, 70, 192, 110, 100, 132, 130, 120, 99, 99, 108, 90, 120, 120, 121, 90, 130, 120, 108, 99, 150, 120, 120, 110,
                120, 120, 132, 143, 110, 132, 40230, 43680, 37250, 110, 110, 110, 120, 110, 120, 120, 120, 120, 108, 110, 99,
                130, 121, 108, 117, 128, 117, 84, 30, 18, 84, 54, 63, 52, 72, 126, 65, 70, 110, 120, 110, 99, 99, 108, 132, 130,
                120, 130, 72, 84, 128, 28, 30, 81, 90, 80, 65, 90, 70, 80, 88, 84, 112, 126, 78, 72, 48, 128, 63, 168, 54, 100, 90,
                88, 99, 108, 120, 120, 100, 108, 108, 108, 110, 99, 108, 91, 84, 65, 99, 99, 99, 130, 120, 143, 120, 117, 120, 132, 120,
                132, 132, 130, 120, 132, 132, 132, 132, 120, 110, 132, 120, 130, 132, 120, 120, 110, 143, 110, 120, 110, 143, 110, 110, 121,
                120, 120, 108, 100, 132, 120, 144, 132, 100, 108, 108, 143, 110, 130, 120, 120, 143, 88, 143, 120, 143, 126, 120, 120, 120, 110,
                100, 160, 143, 120, 90, 100, 99, 99, 100, 120, 108, 108, 130, 120, 120, 120, 121, 130, 121, 182, 90, 110, 132, 108, 120, 132, 120, 70,
                120, 100, 120, 110, 121, 121, 143, 121, 120, 108, 132, 140, 132, 130, 120, 144, 99, 130, 130, 120, 132, 120, 128, 84, 126, 90, 70, 84,
                84, 77, 88, 77, 96, 88, 96, 80, 396, 180, 154, 154, 143, 165, 168, 154, 154, 132, 156, 176, 132, 100, 121, 121, 120, 110, 120, 130, 120,
                121, 110, 117, 110, 121, 110, 120, 110, 132, 120, 110, 120, 120, 84, 84, 65, 84, 88, 126, 77, 77, 77, 77, 90, 35, 63, 63, 110, 72, 77,
                84, 130, 110, 120, 130, 224, 110, 130, 120, 121, 99, 120, 28160, 25, 20);
        System.out.println (rlist (list));

//        int[][] a=new int [3][3];
//        int[][] b=new int [3][3];
//        Photo photo=new Photo (1,1,2,2);
//        List<Photo> list=new ArrayList<> ();
//        for (int i=0;i<10;i++){
//            list.add (photo);
//        }
//        long start=System.nanoTime ()/1_000_000;
//        list.stream ().forEach (e->{
//            for(int i=e.getX ();i<=e.getHeight ();i++){
//                for (int j=e.getY ();j<=e.getWidth ();j++){
//                    a[i][j]+=1;
//                }
//            }
//        });
//        long middle=System.nanoTime ()/1_000_000;
//        list.parallelStream ().forEach (e->{
//            for(int i=e.getX ();i<=e.getHeight ();i++){
//                for (int j=e.getY ();j<=e.getWidth ();j++){
//                    b[i][j]+=1;
//                }
//            }
//        });
//        List<List<Integer>> lists=new ArrayList<> ();
//        for(int i=0;i<3;i++){
//            for(int j=0;j<3;j++){
//                lists.add (Arrays.asList (i,j,a[i][j]));
//            }
//        }
//        System.out.println (lists);

    }
    public static List<List<Integer>> rlist(List<Integer> list){
        Optional<Integer> optional=list.stream ().max (Integer::compareTo);
        int up=optional.orElse (0);
        System.out.println (up);
        int m=((up/10)+1)*10+1;
        int n=m/10;
        List<List<Integer>> listng=new ArrayList<> ();
        list.stream ().forEach (e->{
            for (int i=0;i<m;i+=n){
                if(e>=i&&e<i+n){
                    listng.add (Arrays.asList (i,i+n,e));
                    break;
                }
            }
        });
        System.out.println (listng);
        List<List<Integer>> lists=new ArrayList<> ();
        listng.stream ().collect (Collectors.groupingBy (e->e.get (0))).forEach ((k,v)->{
            lists.add (Arrays.asList (k,k+n,v.size ()));
        });
        System.out.println (lists);
        List<Integer> list1=lists.stream ().map (e->{return e.get (0);}).collect(Collectors.toList());
        System.out.println (list1);
        for(int i=0;i<m;i+=n){
            if(!list1.contains (i)){
                lists.add (Arrays.asList (i,i+n,0));
            }        }

        return lists;
    }

}
class Photo{
    int x;
    int y;
    int width;
    int height;

    public Photo() {
    }

    public Photo(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
