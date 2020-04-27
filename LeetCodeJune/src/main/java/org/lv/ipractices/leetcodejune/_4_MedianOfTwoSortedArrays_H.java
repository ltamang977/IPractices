package org.lv.ipractices.leetcodejune;

public class _4_MedianOfTwoSortedArrays_H {


    public double mediamOfTwoSortedArrays(int[] arr1, int[] arr2){

        /*
        partitionX+partitionY=X+Y+1/2;
          */

        int x = arr1.length;
        int y = arr2.length;

        int low = 0;
        int high = x;

        while(low<=high){

            int partitionX = (low+high)/2;
            int partitionY = (x + y +1)/2 - partitionX;

            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE:arr1[partitionX-1];
            int minRightX = (partitionX==x)?Integer.MAX_VALUE:arr1[partitionX];


            int maxLeftY = (partitionY==0)?Integer.MIN_VALUE:arr1[partitionY-1];
            int minRightY = (partitionY==y)?Integer.MAX_VALUE:arr1[partitionY];


            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x+y)%2==0){
                    //even length
                    return ((double) Math.max(maxLeftX,maxLeftY) +Math.min(minRightX,minRightY))/2;

                }else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }

            } else if(maxLeftX>minRightY){
                high = partitionX-1;

            } else {
                low = partitionY+1;
            }


        }


        throw new IllegalArgumentException("Mediam not found");

    }
}
