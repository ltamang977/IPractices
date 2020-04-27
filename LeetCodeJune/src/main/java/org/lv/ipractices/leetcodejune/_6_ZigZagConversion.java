package org.lv.ipractices.leetcodejune;

public class _6_ZigZagConversion {


    public static void zipZagConversionDemo(String input){
        // converto to matrix

        String str = "PAYPALISHIRING";
        int rowSize = 3;
        int colSize = findColumnSize(str.length(), rowSize);

        char[][] matrix = populateMatrix(str, rowSize, colSize);

        String convertedString = convertToString(matrix);
        System.out.println(convertedString);


    }


    public static int findColumnSize(int n, int rowSize){


        int count = 0;
        int midSize = rowSize-2;

        while(n>0){

            count++;
            if(n>=rowSize){
                n = n-rowSize;
            }else {
                n=n-n;
            }

            int i=0;
            while(n>0 && i<midSize){
                count++;
                n--;
                i++;
            }

        }

        return count;

    }



    public static char[][] populateMatrix(String input, int rowSize, int colSize){


        char[][] matrix = new char[rowSize][colSize];

        int n = input.length();
        int i = 0;
        int midSize = rowSize-2;


        int col = 0;
        while(i<n ){

            int row = 0;
            while(i<n && row<rowSize){
                matrix[row++][col]= input.charAt(i++);

            }

            col++;
            row=midSize;
            while(i<n && row>0){
                matrix[row--][col++]= input.charAt(i++);
            }
        }

        return matrix;

    }
    public static void printMatrix(char[][] matrix){
        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length; j++){
                System.out.printf("  -> %c", matrix[i][j]);
            }
        }
    }

    public static String convertToString(char[][] matrix){

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<matrix.length; i++){
            //System.out.println();
            for(int j=0; j<matrix[0].length; j++){
               // System.out.printf("  -> %c", matrix[i][j]);

                if(matrix[i][j]!='\u0000'){
                    sb.append(matrix[i][j]);
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args){
        zipZagConversionDemo("");
    }
}
