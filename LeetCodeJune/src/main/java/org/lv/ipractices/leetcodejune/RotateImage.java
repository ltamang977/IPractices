package org.lv.ipractices.leetcodejune;

import java.util.Arrays;

public class RotateImage {


    public static void rotateImage(int[][] matrix){
        int levelSize = matrix.length/2;
        int M = matrix.length;

        for(int level = 0; level<levelSize; level++){

            for(int i=level; i<M-1-level; i++){

                //int top = matrix[level][i];
                //int left = matrix[M-1-i][level];
                //int bottom = matrix[M-1-level][M-1-i];
                //int right = matrix[i][M-1-level];

                int temp = matrix[level][i];
                matrix[level][i] = matrix[M-1-i][level];
                matrix[M-1-i][level] = matrix[M-1-level][M-1-i];
                matrix[M-1-level][M-1-i] = matrix[i][M-1-level];
                matrix[i][M-1-level] = temp;
            }

        }
    }

    public static void main(String[] args){

        int[] row0 = {1, 2, 3};
        int[] row1 = {4, 5, 6};
        int[] row2 = {7, 8, 9};


        int[][] matrix = {row0, row1, row2};

        rotateImage(matrix);
        System.out.println(Arrays.toString(matrix));

    }
}
