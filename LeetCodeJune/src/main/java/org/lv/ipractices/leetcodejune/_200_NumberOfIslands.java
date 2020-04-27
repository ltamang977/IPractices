package org.lv.ipractices.leetcodejune;

import java.util.List;

public class _200_NumberOfIslands {

    public static int numberOfIslands(char[][] grid){

        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]=='1'){
                    count++;
                    merge(grid, i, j);
                }

            }
        }

        return count;


    }



    public static void merge(char[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='1'){
            return;
        }

        grid[i][j] = 'X';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }


    public static void main(String[] args){

        /*
        11000
        11000
        00100
        00011
         */

        char[] zero = {'1', '1', '0', '0', '0'};
        char[] one = {'1', '1', '0', '0', '0'};
        char[] two = {'0', '0', '1', '0', '0'};
        char[] three = {'0', '0', '0', '1', '1'};

        char[][] grid = {zero, one, two, three};

        int count = numberOfIslands(grid);

        System.out.println("Count is :"+count);

    }
}
