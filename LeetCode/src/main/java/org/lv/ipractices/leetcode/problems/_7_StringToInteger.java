package org.lv.ipractices.leetcode.problems;

public class _7_StringToInteger {

        public static int myAtoi(String str) {

            if(str==null || str.length()==0)
                return 0;

            str=str.trim();

            int startIndex=0;
            if(str.charAt(0)=='-' || str.charAt(0)=='+'){
                startIndex++;
            }

            boolean isNegative=false;
            if(str.charAt(0)=='-'){
                isNegative=true;
            }

            double nbr = 0;
            for(int i=startIndex; i<str.length(); i++){
                if(str.charAt(i)<'0' || str.charAt(i)>'9')
                    break;
                int digit = str.charAt(i)-'0';
                nbr=nbr*10+digit;

            }

            if(isNegative){
                nbr =  -nbr;
            }

            if(nbr>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(nbr<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return (int)nbr;

        }


        public static void main(String[] args){

            String s = "      010";
            System.out.println(myAtoi(s));

        }

}
