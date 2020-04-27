package org.lv.ipractices.revisionaprend.bytebybyte;

public class _15_RotateBits {



    public static int rotateBits(int x, int n){

        int totalBits = 32;

        return x>>n | x<<(totalBits-n);


    }

    public static void main(String[] args){

        int val = 0xABCD11AB;
        System.out.println(rotateBits(val, 8));
    }

}
