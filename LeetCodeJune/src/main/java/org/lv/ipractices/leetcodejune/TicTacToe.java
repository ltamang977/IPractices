package org.lv.ipractices.leetcodejune;



    public class TicTacToe {

    /** Initialize your data structure here. */
    int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=0){
            return 0;
        }

        board[row][col]=player;
        //validate
        return findWinner(row, col, player);

    }

    public int findWinner(int row, int col,int player){

        //validate row
        boolean valid=true;
        for(int i=0; i<board[0].length; i++){
            if(board[row][i]!=player){
                valid = false;
                break;
            }
        }
        if(valid){
            return player;
        }
        //row passed

        //validate col
        for(int i=0; i<board.length; i++){
            if(board[i][col]!=player){
                valid = false;
                break;
            }
        }
        if(valid){
            return player;
        }

        //validate diagonal
        for(int i=0; i<board.length; i++){
            if(board[i][i]!=player){
                valid = false;
                break;
            }
        }
        if(valid){
            return player;
        }

        //validate diagonal
        for(int i=0; i<board.length; i++){
            if(board[i][board.length-1-i]!=player){
                valid = false;
                break;
            }
        }
        if(valid){
            return player;
        }

        return 0;

    }


    public static void main(String[] args){

        /*
        ["TicTacToe","move","move","move"]
[[2],[0,0,2],[0,1,1],[1,1,2]]
         */

        TicTacToe ticTac = new TicTacToe(2);
        ticTac.move(0,0,2);
        ticTac.move(0,1,1);
        ticTac.move(1, 1, 2);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */