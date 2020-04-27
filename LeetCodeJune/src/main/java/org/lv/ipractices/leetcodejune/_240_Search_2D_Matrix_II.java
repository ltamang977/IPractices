package org.lv.ipractices.leetcodejune;

public class _240_Search_2D_Matrix_II {

    public boolean searchMatrix_II(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;


        int i = m-1;
        int j = 0;


        while(i>=0 && j<=n-1){

            if(matrix[i][j]==target){
                return true;

            } else if (target<matrix[i][j]){
                i--;

            } else {
                j++;

            }

        }

        return false;

    }




    public static void main(String[] args){

        int[] first = {1, 4, 7, 11, 15};
        int[] second = {2, 5, 8, 12, 19};
        int[] third = {3, 6, 9, 16, 22};
        int[] fourth = {10, 13, 14, 17, 24};
        int[] fifth = {18, 21, 23, 26, 30};

        int[][] matrix = {first, second, third, fourth, fifth};

        _240_Search_2D_Matrix_II sol = new _240_Search_2D_Matrix_II();

        System.out.println("Search is :"+sol.searchMatrix_II(matrix, 15));

    }

}
