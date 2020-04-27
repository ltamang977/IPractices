package org.lv.ipractices.leetcodejune;

public class _36_ValidSoduko {


    public static boolean valdate(char[][] matrix){

        boolean[] status = new boolean[matrix.length*matrix.length];

        return validateRow(matrix)
                && validateCol(matrix)
                && validCubes(matrix);


    }


    public static boolean validCubes(char[][] board) {
        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (m[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        m[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }



    public static boolean validateRow(char[][] matrix){

        for(int row=0; row<matrix.length; row++) {
            //reset rows
            boolean[] status = new boolean[9];
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] != '.') {
                    if (status[matrix[row][col]-'1']) {
                        return false;
                    }
                    status[matrix[row][col]-'1'] = true;
                }
            }
        }
        return true;
    }


    public static boolean validateCol(char[][] matrix){

        for(int col=0; col<matrix[0].length; col++) {
            boolean[] status = new boolean[9];
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] != '.') {
                    if (status[matrix[row][col]-'1']) {
                        return false;
                    }
                    status[matrix[row][col]-'1'] = true;
                }
            }

        }

        return true;

    }


    public static void main(String[] args){

        char[] ch0 = {'5','3','.','.','7','.','.','.','.'};
        char[] ch1 = {'6','.','.','.','9','5','.','.','.'};
        char[] ch2 = {'.','9','8','.','.','.','.','6','.'};
        char[] ch3 = {'8','.','.','.','6','.','.','.','3'};
        char[] ch4 = {'4','.','.','8','.','3','.','.','1'};
        char[] ch5 = {'7','.','.','.','2','.','.','.','6'};
        char[] ch6 = {'.','6','.','.','.','.','2','8','.'};
        char[] ch7 = {'.','.','.','4','1','9','.','.','5'};
        char[] ch8 = {'.','.','.','.','8','.','.','7','9'};

        char[][] matrix = {ch0, ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8};

        System.out.println(valdate(matrix));

    }
}
