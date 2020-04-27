package org.lv.ipractices.revisionaprend.bytebybyte;

public class _4_CountOnesInBinary {



    public static int countOneAnd(int binary){
        int count=0;
        int one = 1;
        while(binary>0){
            count+=binary&one;
            binary>>=1;
        }
        return count;

    }

    public static int countOnesMod(int binary){
        int count=0;
        int one = 1;
        while(binary>0){
            count+=binary%2;
            binary>>=1;
        }
        return count;

    }


    public static void main(String[] args){
        int binary = 0b10101011;
        System.out.println(countOnesMod(binary));


    }
}
