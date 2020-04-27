package org.lv.ipractices.leetcode.array.matrix;

/**
 * Created by root on 1/27/18.
 */
public class Search2DMatrix {


    public static boolean search2DMatrix(int[][] matrix, int target){

        for(int row=0; row<matrix.length; row++){
            System.out.println("Searching row :"+row);

            if(matrix[row][0]<target && matrix[row][matrix[0].length-1]>target) {

                int left = 0;
                int right = matrix[0].length-1;

                while(left<right){
                    int mid = left +(right-left)/2;
                    if(matrix[row][mid]==target){
                        return true;

                    }else if(matrix[row][mid]<target){
                        //go right
                        left=mid+1;

                    }else if (matrix[row][mid]>target){
                        // go left
                        right=mid-1;

                    }
                }

            }

        }
        return false;

    }


    public static void main(String[] args){

        int[][] matrix = new int[3][4];
        matrix[0][0]=1;
        matrix[0][1]=3;
        matrix[0][2]=5;
        matrix[0][3]=7;
        matrix[1][0]=10;
        matrix[1][1]=11;
        matrix[1][2]=16;
        matrix[1][3]=20;
        matrix[2][0]=23;
        matrix[2][1]=30;
        matrix[2][2]=34;
        matrix[2][3]=50;

        boolean result = search2DMatrix(matrix, 3);
        System.out.println("Search target is :"+result);


    }
}
