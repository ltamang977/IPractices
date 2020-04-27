package org.lv.ipractices.leetcodejune;

public class _74_Search_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        return binarySearchCol(matrix, 0, matrix.length-1, target);

    }

    public boolean binarySearchCol(int[][] matrix, int top, int bottom, int target){

        if(bottom<top){
            return false;
        }

        int mid = top+(bottom-top)/2;

        if(target==matrix[mid][0]){
            return true;

        }

        if(mid>0 && target>matrix[mid-1][0] && target<matrix[mid][0]){
            return binarySearchRow(matrix[mid-1],  0,  matrix[mid-1].length-1,  target);

        }else if(mid==matrix.length-1 && target>matrix[mid][0]){
            return binarySearchRow(matrix[mid],  0,  matrix[mid].length-1,  target);

        }

        if(target<matrix[mid][0]){
           return  binarySearchCol(matrix, top,  mid-1, target);
        }

        return binarySearchCol(matrix, mid+1,  bottom, target);


    }


    public boolean binarySearchRow(int[] arr, int left, int right, int target){

        if(right<left){
            return false;
        }


        int mid = left+(right-left)/2;

        if(target==arr[mid]){
            return true;

        } else if(target<arr[mid]){
            return binarySearchRow(arr, left, mid-1, target);

        }else {
            return binarySearchRow(arr, mid+1, right, target);
        }


    }

    public static void main(String[] args){


         /*
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
         */


         /*
         matrix = [
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
        ]
          */


        int[] first = {1, 3, 5, 7};
        int[] second = {10, 11, 16, 20};
        int[] third = {23, 30, 34, 50};

        int[][] matrix = {first, second, third};

        _74_Search_2D_Matrix sol = new _74_Search_2D_Matrix();

        System.out.println("Search is :"+sol.searchMatrix(matrix, 13));

    }

}
