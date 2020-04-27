package org.lv.ipractices.ctci._1_arraysandstrings;

/**
 * Created by root on 12/30/17.
 */
public class _7_MatrixWithZero {

    public static int[][] fillRowsAndColumns(int[][] matrix){

        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];

        for(int i=0;i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    rows[i]=1;//means to fill
                    columns[j]=1;//to fill
                }
            }
        }

        //zeroing all colums for follwoing rows
        for(int i=0; i<rows.length; i++){
            if(rows[i]==1) {
                System.out.println("Rows to fill :" + i);
                for (int c = 0; c < matrix[0].length; c++) {
                    matrix[i][c] = 0;
                }
            }
        }

        //zerowing all rows for following columns
        for(int i=0;i< columns.length; i++){
            if(columns[i]==1) {
                System.out.println("Columns to fill :" + i);
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][i] = 0;
                }
            }
        }

        return matrix;

    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                System.out.printf("%2d",matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[4][3];

        matrix[0][0]=0;
        matrix[0][1]=1;
        matrix[0][2]=1;

        matrix[1][0]=1;
        matrix[1][1]=1;
        matrix[1][2]=1;

        matrix[2][0]=1;
        matrix[2][1]=0;
        matrix[2][2]=1;

        matrix[3][0]=1;
        matrix[3][1]=1;
        matrix[3][2]=1;

        printMatrix(matrix);

        int[][] filledMatrix = fillRowsAndColumns(matrix);

        printMatrix(filledMatrix);


    }
}
