package org.lv.ipractices.programcreek.matrix;


public class _1_SetMatrixZeroes {



    public static void setMatrixZeroes(int[][] matrix){

        if(matrix == null || matrix.length==0 || matrix[0].length==0)
            return;

        boolean isFirstRowZeroes = false;
        boolean isFirstColumnZeroes = false;

        //check first row for zeroes
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i]==0){
                isFirstRowZeroes = true;
                break;
            }
        }

        //check first col for zeroes
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0]==0){
                isFirstColumnZeroes = true;
                break;
            }
        }


        //mark first rows and cols fpr presence of zeroes
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }

            }
        }

        //update fields depending on marks
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }

            }
        }

        if(isFirstRowZeroes){
            for(int i=0; i<matrix[0].length; i++){
                matrix[0][i]=0;
            }
        }

        if(isFirstColumnZeroes){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0]=0;
            }
        }

    }


    public static void printMatrix(int[][] matrix){

        System.out.println("Printing matrix : ");
        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length; j++){
                System.out.printf(" %d ", matrix[i][j]);
            }
        }

    }

    public static void main(String[] args){

        int[] first = {1, 1, 1};
        int[] second = {1, 0, 1};
        int[] third = {1, 1, 1};

        int[][] matrix = {first, second, third};

        printMatrix(matrix);
        setMatrixZeroes(matrix);
        printMatrix(matrix);

    }

}
