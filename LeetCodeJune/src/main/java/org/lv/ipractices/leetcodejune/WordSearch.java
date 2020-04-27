package org.lv.ipractices.leetcodejune;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(word.charAt(0)==board[row][col]){
                    boolean flag = dfs(board, row, col, word, 0);
                    if(flag){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static boolean dfs(char[][] board, int row, int col, String word, int start){

        if(start==word.length()){
            return true;
        }

        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }

        if(board[row][col]==word.charAt(start)){
            return dfs(board, row+1, col, word, start+1)
                    ||  dfs(board, row, col+1, word, start+1)
                    ||  dfs(board, row-1, col, word, start+1)
                    || dfs(board, row, col-1, word, start+1);

        }

        return false;

    }

    public static void main(String[] args){

        char[] row0 = {'A','B','C','E'}  ;
        char[] row1 = {'S','F','C','S'}  ;
        char[] row2 = {'A','D','E','E'}  ;

        char[][] board= {row0, row1, row2};
       // String word = "ABCCED";
        String word = "AB";

        boolean result =  exist( board, word);

    }
}
