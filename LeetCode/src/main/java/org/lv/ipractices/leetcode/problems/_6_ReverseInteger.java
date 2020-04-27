package org.lv.ipractices.leetcode.problems;

public class _6_ReverseInteger {

    public static int reverse(int x) {

        int y = 0;
        while(x!=0){
          int temp = y*10+x%10;
          if(temp/10!=y)
              return 0;
            y=temp;
            x=x/10;
        }

        return y;

    }


    public static void main(String[] args){
        int i = -123;
        reverse(i);
    }

}
