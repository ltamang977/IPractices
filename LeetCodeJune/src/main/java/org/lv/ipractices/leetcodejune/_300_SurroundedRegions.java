package org.lv.ipractices.leetcodejune;

public class _300_SurroundedRegions {



    public static void surroundedRegions(char[][] grid){

        if(grid==null || grid.length==0 || grid[0].length==0){
            return;
        }

        int m = grid.length;
        int n = grid[0].length;

        //top and bottom
        for(int i=0; i<n; i++){
            if(grid[0][i]=='0'){
                merge(grid, 0, i);
            }

            if(grid[m-1][i]=='0'){
                merge(grid, m-1, i);
            }
        }

        //left and right
        for(int i=0; i<m; i++){
            if(grid[i][0]=='0'){
                merge(grid, i, 0);
            }

            if(grid[n-1][i]=='0'){
                merge(grid, i, n-1);
            }
        }

        //process
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='0'){
                    grid[i][j]='X';

                }else if(grid[i][j]=='#'){
                    grid[i][j]='0';
                }
            }
        }

    }



    public static void merge(char[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]!='0'){
            return;
        }

        grid[i][j] = '#';

        merge(grid, i-1, j);
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }


    public static void printMatrix(char[][] matrix){

        for(int i=0; i<matrix.length; i++){
            System.out.println();
            for(int j=0; j<matrix[0].length; j++){
                System.out.printf(" %c",matrix[i][j]);
            }
        }
    }

    public static void main(String[] args){

        /*
        X X X X
        X O O X
        X X O X
        X O X X
         */

        char[] zero = {'X', 'X', 'X', 'X'};
        char[] one = {'X', '0', '0', 'X'};
        char[] two = {'X', 'X', '0', 'X'};
        char[] three = {'X', '0', 'X', 'X'};

        char[][] grid = {zero, one, two, three};

        surroundedRegions(grid);
        printMatrix(grid);

    }
}
