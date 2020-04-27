package org.lv.ipractices.leetcodejune;

public class _43_MultiplyStrings {


    public static String multiplyString(String nums1, String nums2){

        long sum = 0;

        int xOffset = 1;
        for(int i=nums1.length()-1; i>=0; i--){


            int x = nums1.charAt(i)-'0';

            long val = 0;
            int carry = 0;

            int yOffset = 1;
            for(int j=nums2.length()-1; j>=0; j--){


                int y = nums2.charAt(j)-'0';

                int mul = x*y;
                mul = mul +carry;

                carry = mul/10;
                int lastDigit = mul%10;
                val = yOffset * lastDigit + val;

                yOffset = yOffset * 10;

            }
            if(carry!=0){
                val = carry*yOffset + val;
            }

            sum = xOffset * val+sum;
            xOffset = xOffset * 10;
        }

        return String.valueOf(sum);


    }


    public static void main(String[] args){

        String nums1 = "123";
        String nums2 = "456";

        String result = multiplyString( nums1,  nums2);
        System.out.println(result);
    }
}
