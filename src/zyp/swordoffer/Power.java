package zyp.swordoffer;

import com.sun.org.omg.CORBA.ExceptionDescription;

import static java.lang.Math.abs;

/**
 * @author zyp
 */
public class Power {
    public double Power(double base, int exponent) {
        if(base == 0 && exponent < 0){
            throw new RuntimeException("分母不能为0");
        }
        if(exponent == 0) {return 1;}
        boolean flag = exponent >0 ? true:false;
        exponent = Math.abs(exponent);
        double result = 1.0;
        while(exponent!=0){
            if((exponent & 1) == 1) {
              result = result * base;
            }
            base *= base;
            exponent >>= 1;
        }
        result = flag == true?result:1/result;
        return result;
    }




    public static void main(String[] args) {
        double x=1.1;
        Power p = new Power();
        double result = p.Power(x,2);
        System.out.println(result);
        System.out.println(1.1*1.1);
    }
}
