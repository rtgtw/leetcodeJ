package Leetcode.BinarySearch;

public class Search2DMatrix74 {


    public static boolean searchMatrix(int[][] matrix, int target){


        if(matrix.length == 1){
            int low = 0;
            int high = matrix[0].length - 1;


            while(low <= high){

                int midPoint = low + ((high - low) / 2);

                if(matrix[0][midPoint] == target){
                    return true;
                }else if(matrix[0][midPoint] > target){
                    high = midPoint - 1;
                }else{
                    low = midPoint + 1;
                }
            }
        }
        if(matrix.length == 1){
            return false;
        }
        //double binary search, do a binary search on M(columns) to figure out which is the correct row
        //[row][column]
        //mid point for columns (first value, b/c of condition)
        //first value of each column would be [row][0]
        //get the first row which is [0][0]
        //get the last row which is [matrix.length - 1][0]
        // perform binary search on columns
        int low = 0;
        int high = matrix.length - 1;


        //if there is only 1 row, do a normal binary search


        //midpoint equation, midPoint = low + ((high - low) / 2)

        //this is going to return which row we have to perform
        //the other binary search in, low or high will hold the value
        while(low <= high){
            //calculate the midPoint
            int midPoint = low + ((high - low) / 2);

            if(matrix[midPoint][0] == target){
                high = midPoint;
                break;
            }else if(matrix[midPoint][0] > target){
                high = midPoint - 1;
            }else{
                low = midPoint + 1;
            }

        }

        //now we have the correctRow, we can perform a normal binary search
        int rowLow = 0;
        int rowHigh = matrix[0].length - 1;

        while (rowLow <= rowHigh){

            int rowMidPoint = rowLow + ((rowHigh - rowLow) / 2);

            if(matrix[high][rowMidPoint] == target){
                return true;
            }else if(matrix[high][rowMidPoint] > target){
                rowHigh = rowMidPoint - 1;
            }else{
                rowLow = rowMidPoint + 1;
            }
        }

        return false;
    }






    public static void main(String args[]){

        int [][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                           {23,30,34,60}};

        int[][] matrix1 = {{1},{3}};

        System.out.println(Search2DMatrix74.searchMatrix(matrix1, 0));
    }
}
