package org.lv.ipractices.leetcodejune;

public class _38_CountAndSay_E {


    public static String countAndSay(int n){

        if(n==0)
            return null;

        String str = "1";

        for(int i=1; i<n; i++){


            int count = 1;
            char lastChar = str.charAt(0);
            String s = "";
            for(int j=1; j<str.length(); j++){

                if(str.charAt(j)!=lastChar){
                    s=s+count;
                    s=s+lastChar;
                    count = 1;
                    lastChar = str.charAt(j);

                }else {
                    count++;

                }

            }
            s=s+count;
            s=s+lastChar;

            str = s;

        }

        return str;


    }


    public static void main(String[] args){
        System.out.println(countAndSay(5));

    }
}
