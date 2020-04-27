package org.lv.ipractices.leetcodejune;

import java.util.List;

public class _59_SpiralMatrix_II {


    public static int[][] generateMatrix(int n){

        int[][] matrix = new int[n][n];

        int levelSize = n/2;

        int nbr = 1;
        for(int level=0; level<=levelSize; level++){

            int len = n- 2*level;

            if(len==1){
                matrix[level][level]=nbr;
                break;
            }


            //top
            for(int i=level; i<n-1-level; i++){
                matrix[level][i] = nbr++;
            }

            //right
            for(int i=level; i<n-1-level; i++){
                matrix[i][n-1-level] = nbr++;
            }

            //bottom
            for(int i=n-1-level; i>level; i--){
                matrix[n-1-level][i] = nbr++;
            }

            //left
            for(int i=n-1-level; i>level; i--){
                matrix[i][level] = nbr++;
            }
        }

        return matrix;
    }


    public static void printMatrix(int[][] matrix){

        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length; j++){
                System.out.printf(" %d",matrix[i][j]);
            }
        }
    }



    public static void main(String[] args){



    }
}
