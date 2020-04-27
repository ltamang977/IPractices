package org.lv.ipractices.revisionaprend.bytebybyte;

public class _52_MedianOfSortedArrays {


    public static double medianOfSortedArrays(int[] arr1, int[] arr2){

        int x = arr1.length;
        int y = arr2.length;

        int total = (x+y+1)/2;

        int lo = 0;
        int hi = x;

        while(lo<=hi){

            int partitionX = (lo+hi)/2;
            int partiotionY = total - partitionX;

            int maxLeftX = (partitionX==0)?Integer.MIN_VALUE: arr1[partitionX-1];
            int minRightX = (partitionX==x)?Integer.MAX_VALUE: arr1[partitionX];

            int maxLeftY = (partiotionY==0)?Integer.MIN_VALUE: arr2[partiotionY-1];
            int minRightY = (partiotionY==y)?Integer.MAX_VALUE: arr2[partiotionY];

            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                //valid case
                if((x+y)%2==0){//even length
                    return ( (double) Math.max(maxLeftX,maxLeftY) + Math.max(minRightX,minRightY))/2;
                }

                return (double) Math.max(maxLeftX,maxLeftY);

            }else if (maxLeftX>minRightY){
                hi = partitionX-1;

            }else {
                lo = partitionX;

            }
        }

        throw new IllegalArgumentException("median not found");

    }


    public static void main(String[] args) {

        int[] arr1 = {1, 3, 8, 9, 15};
        int[] arr2 = {7, 11, 18, 19, 21, 25};

        double median = medianOfSortedArrays(arr1, arr2);
        System.out.println("Median is :" + median);


    }


}
