package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {


    public static List<Integer> spiralOrder(int[][] matrix){

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return null;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>();


        int x = 0;
        int y = 0;

        while(m>0 && n>0){

            if(m==1){
                for(int i=0; i<n; i++){
                    list.add(matrix[x][y++]);
                }
                break;

            } else if(n==1){
                for(int i=0; i<m; i++){
                    list.add(matrix[x++][y]);
                }
                break;

            }

            //top
            for(int i=0; i<n-1; i++){
                list.add(matrix[x][y++]);
            }

            //right
            for(int i=0; i<m-1; i++){
                list.add(matrix[x++][y]);
            }

            //bottom
            for(int i=0; i<n-1; i++){
                list.add(matrix[x][y--]);
            }

            //left
            for(int i=0; i<m-1; i++){
                list.add(matrix[x--][y]);
            }

            x++;
            y++;
            m=m-2;
            n=n-2;


        }

        return list;

    }



    public static void printSpiral(int[][] matrix){

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int levelSize = Math.min(rowLen, colLen);

        for(int level = 0; level<levelSize; level++){

            //top
            for(int col=level; col<colLen-1-level; col++){
                System.out.printf(" %d", matrix[level][col]);
            }

            //right
            for(int row=level; row<rowLen-1-level; row++){
                System.out.printf(" %d", matrix[row][colLen-1-level]);
            }

            //bottom
            for(int col=colLen-1-level; col>level; col--){
                System.out.printf(" %d", matrix[rowLen-1-level][col]);
            }

            //left
            for(int row=rowLen-1-level; row>level; row--){
                System.out.printf(" %d", matrix[row][level]);
            }
        }
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


        int[] zero = {1,2,3};
        int[] one = {4,5,6};
        int[] two = {7,8,9};
        int[] three = {10,11,12};

        int[][] matrix = {zero, one, two, three};
        printMatrix(matrix);

        List<Integer> list = spiralOrder(matrix);
        System.out.println(list.toString());
       // printSpiral(matrix);

    }
}
