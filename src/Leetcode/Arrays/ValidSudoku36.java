package Leetcode.Arrays;

//HashSet to make sure there are no duplicates for the rows, for each row

//HashSet for every columns

import java.util.HashSet;

//Hashset to represent the 3x3 grid
public class ValidSudoku36 {


    public static boolean isValidSudoku(char board[][]){

        HashSet<Character> rowSet = new HashSet<>();

        //Checks all of the rows
        for(char [] x : board){
            for(char y : x){
                if(rowSet.contains(y) && y != '.'){
                    return false;
                }
                rowSet.add(y);
            }
            rowSet.clear();
        }

        //board.length = 3 gets the column
        //in the for loop we want to perform
        //another for loop that iterates
        for(int i = 0; i < board.length; i++){
                //This gets the row
            for(int n = 0; n < board[0].length; n++){
                if(rowSet.contains(board[n][i]) && board[n][i] != '.'){
                    return false;
                }
                rowSet.add(board[n][i]);
            }
            rowSet.clear();
        }


        //Last one to consider is the box, to map the ones in the box do r/3 and c/3
        //check all 3 boxes
        for(int boxRow = 0; boxRow < 9; boxRow +=3){
            for(int boxCol = 0; boxCol < 9; boxCol +=3){
                rowSet.clear();


                //loop through each element
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char current = board[boxRow + i][boxCol + j];

                        if(rowSet.contains(current) && current != '.'){
                            return false;
                        }

                        rowSet.add(current);
                    }
                }
            }
        }


        return true;
    }

    public static void main(String args[]){

        char sudoku [][] = {{'5','3','.','.','7','.','.','.','.'}
                           ,{'6','.','.','1','9','5','.','.','.'}
                           ,{'.','9','8','.','.','.','.','6','.'}
                           ,{'8','.','.','.','6','.','.','.','3'}
                           ,{'4','.','.','8','.','3','.','.','1'}
                           ,{'7','.','.','.','2','.','.','.','6'}
                           ,{'.','6','.','.','.','.','2','8','.'}
                           ,{'.','.','.','4','1','9','.','.','5'}
                           ,{'.','.','.','.','8','.','.','7','9'}};

        char lengthCheck[][] = {{'.','.','.'},
                                {'.','.','.'},
                                {'.','.','.'},
                                {'.','.','.'},
                                {'.','.','.'}};

        System.out.println(ValidSudoku36.isValidSudoku(sudoku));
        //This gets column lengthCheck.length
        //This gets row lengthCheck[0].length
//        System.out.println(lengthCheck[0].length);

    }
}
