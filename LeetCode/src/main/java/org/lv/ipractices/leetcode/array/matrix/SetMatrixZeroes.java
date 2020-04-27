package org.lv.ipractices.leetcode.array.matrix;

/**
 * Created by root on 1/24/18.
 */
public class SetMatrixZeroes {


    /**
     * O(r+c) extra space
     * @param matrix
     */
    public static void setMatrixZeroes(int[][] matrix){
        int[] rows = new int[3];
        int[] columns = new int[3];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows[i]=1;
                    columns[j]=1;
                }

            }
        }

        //setting all colmuns in a given row to 0
        for(int i=0; i<rows.length ; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(rows[i]==1){
                    matrix[i][j]=0;
                }
            }
        }

        for(int i=0; i<columns.length ; i++){
            for(int j=0; j<matrix.length; j++){
                if(columns[i]==1){
                    matrix[j][i]=0;
                }
            }
        }

    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length;j++){
                System.out.print("->"+matrix[i][j]);
            }
        }
    }


    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;
        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=6;
        matrix[2][0]=0;
        matrix[2][1]=8;
        matrix[2][2]=9;

        printMatrix(matrix);
        setMatrixZeroes(matrix);
        printMatrix(matrix);
    }
}
