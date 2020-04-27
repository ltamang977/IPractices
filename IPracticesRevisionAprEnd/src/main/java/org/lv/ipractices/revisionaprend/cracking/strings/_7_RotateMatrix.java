package org.lv.ipractices.revisionaprend.cracking.strings;

public class _7_RotateMatrix {

    //180 degree rotation
    public static void rotateMatrix(int[][] matrix){

        for(int layer = 0; layer<matrix.length/2; layer++){
            int first= layer;
            int last= matrix.length-1-layer;

            for(int i=first; i<=last; i++){

                int top = matrix[first][i];
                matrix[first][i] = matrix[last-i][first];
                matrix[last-i][first] = matrix[last][last-i];
                matrix[last][last-i]= matrix[i][last];
                matrix[i][last] = top;

            }
        }

    }

    //90 degree rotation
    public static void rotateMatrixCC(int[][] matrix){

        for(int layer = 0; layer<matrix.length/2; layer++){
            int first= layer;
            int last= matrix.length-1-layer;

            for(int i=first; i<last; i++){

                int offset = i-first;

                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset]= matrix[i][last];
                matrix[i][last] = top;

            }
        }

    }


    public static void print(int[][] matrix){

        for(int row=0; row<matrix.length; row++){
            System.out.println("\n");
            for(int col=0; col<matrix[0].length; col++){
                System.out.printf("-> %d", matrix[row][col]);
            }
        }
    }


    public static void main(String[] args){

        /*int[][] matrix= {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };*/

        int[][] matrix= {
                {1,2},
                {3,4}
        };

        System.out.println("Printing original matrix :\n");
        print(matrix);

        rotateMatrix(matrix);
        //rotateMatrixCC(matrix);

        System.out.println("Printing rotated matrix :\n");
        print(matrix);
    }
}
