package org.lv.ipractices.leetcode.integer;

/**
 * Created by root on 1/21/18.
 */
public class StringToInteger {

    public static int stringToInteger(String nbr){


        if(nbr==null)
            return 0;

        if(nbr=="")
            return 0;

        int start = 0;
        boolean flag=false;
        char[] chArr = nbr.toCharArray();
        for(int i=0; i<chArr.length;i++){
            if(chArr[i]!=' '){
                start=i;
                break;
            }

        }

        if(start=='-') {
            flag =true;
            start++;
        }

        int n=0;
        for(int i=start; i<chArr.length; i++){
            int digit = chArr[i]-'0';
            if(digit<0 || digit>9){
                return 0;
            }
            n= n*10+digit;
        }

        if(flag)
            return (0-n);

        return n;

    }


    public static void main(String[] args){
        String str1 = "120";
        System.out.println("Converted value is :"+stringToInteger(str1));
    }
}
