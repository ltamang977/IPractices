package org.lv.ipractices.leetcodejune;

public class ReverseInteger {

    public static int reverse(int x) {

        int reverse = 0;
        while(x!=0){

            int mod = x%10;
            int div = x/10;
            if(div*10+mod!=x)
                return 0;
            reverse= reverse*10+mod;
            x=div;
        }

        return reverse;

    }

    public static void main(String[] args){
        int x = 0005;
        int result = reverse( x);
    }
}
