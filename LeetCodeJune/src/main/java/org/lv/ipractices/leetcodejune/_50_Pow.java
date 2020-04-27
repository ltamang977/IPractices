package org.lv.ipractices.leetcodejune;

public class _50_Pow {



    public static double pow(double x, int n){

        if(n==0)
            return 1;

        if(n<0){
            n = -n;
            x= 1/x;
        }

        return (n%2==0)?pow(x*x, n/2):x*pow(x*x, n/2);
    }


   /* public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }*/


    public static void main(String[] args){

        double pow = pow(2.0, 5);
        System.out.println(pow);

    }
}
