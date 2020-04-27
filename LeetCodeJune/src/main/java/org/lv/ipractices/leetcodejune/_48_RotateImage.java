package org.lv.ipractices.leetcodejune;

public class _48_RotateImage {

    public static void rotateImage(int[][] matrix){


        int levelSize = matrix.length/2;

        for(int level = 0; level<levelSize; level++){

            for(int i=level; i<matrix.length-1-level; i++){


                int top = matrix[level][i];
                int right = matrix[i][matrix.length-1-level];
                int bottom = matrix[matrix.length-1-level][matrix.length-1-i];
                int left = matrix[matrix.length-1-i][level];


                int temp = matrix[level][i];

                // left to top
                matrix[level][i] = matrix[matrix.length-1-i][level];

                //bottom to left
                matrix[matrix.length-1-i][level] = matrix[matrix.length-1-level][matrix.length-1-i];

                //right to bottom
                matrix[matrix.length-1-level][matrix.length-1-i] = matrix[i][matrix.length-1-level];

                //top to right
                matrix[i][matrix.length-1-level]= temp;



                //top = left;
                //left = bottom;
                //bottom=right;
                //right= left;
                //left = temp;

            }
        }

    }

    /*
      public static void rotateImage(int[][] matrix){


        int levelSize = matrix.length/2;

        for(int level = 0; level<levelSize; level++){

            for(int i=level; i<matrix.length-1-level; i++){

                int temp = matrix[level][i];
                matrix[level][i] = matrix[matrix.length-1-level-i][level];
                matrix[matrix.length-1-level-i][level] = matrix[matrix.length-1-level][matrix.length-1-level-i];
                matrix[matrix.length-1-level][matrix.length-1-level-i]= matrix[level+i][matrix.length-1-level];
                matrix[level+i][matrix.length-1-level]=temp;
            }
        }

    }
     */

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length; j++){
                System.out.printf(" ->%d", matrix[i][j]);
            }
        }
    }


    public static void main(String[] args){

        int[] first = {1, 2, 3};
        int[] second = {4, 5, 6};
        int[] third = {7, 8, 9};

        int[][] matrix = {first, second, third};

        printMatrix(matrix);

        rotateImage(matrix);

        System.out.println();

        printMatrix(matrix);
    }
}
