package java8;
import java.util.function.DoubleUnaryOperator;

public class MethodRelay {
    public static void main(String[] args) {
        DoubleUnaryOperator doubleUnaryOperator=co (Math.PI,2.0);
        DoubleUnaryOperator sdk=ro (Math.PI);
        double lenCircle=doubleUnaryOperator.applyAsDouble (3);
        double rouCircle=sdk.applyAsDouble (3);
        System.out.println (lenCircle);
        System.out.println (rouCircle);
    }
    public static DoubleUnaryOperator co(double y, double z){
        return  (double x)-> (x*y)*z;
    }
    public static DoubleUnaryOperator ro(double y){
        return  (double x)-> Math.pow (x,2)*y;
    }
}
