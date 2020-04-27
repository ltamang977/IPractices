package org.lv.ipractices.revisionaprend.bytebybyte;

public class _20_GrayNumber {



    public static boolean isGray(int a, int b){

        int x = a^b;

        while(x>0){
            if(x%2==1 && x>>1 > 0){
               return false;
            }
            x= x>>1;
        }
        return true;

    }


    public static boolean isGrayAlt(int a, int b){

        int x = a^b;

        return (x & (x-1))==0;

    }


    public static void main(String[] args){

        int a = 1;
        int b = 0;
        System.out.println(isGray(a, b));
    }


}
