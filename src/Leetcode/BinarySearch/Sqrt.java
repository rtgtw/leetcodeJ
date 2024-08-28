package Leetcode.BinarySearch;
import Helper.Runtime;

/*
problem 69.
This requires a binary search
solve for base case, if x is 0 or 1 return x
perform a binary search, we are rounding down
*
* */
public class Sqrt {


    public int mySqrt(int x){


        if(x < 2){
            return x;
        }

        //pivot * pivot should be a long
        long cal;

        //initialize left and right pointers
        int left = 2;
        int right = x / 2;

        while(left < right){
            //initialize the pivot
            int pivot = left + ((right - left) / 2);
            cal = (long)pivot * pivot;

            //we need to go down
            if(cal > x ){
                right = pivot - 1;
            }else if (cal < x){
                left = pivot + 1;
            }else{
                return pivot;
            }
        }

        //if it does not find it return the lower bound (right)
        return right;

    }







    public static void main(String args[]){

        Sqrt sol = new Sqrt();

        System.out.println(sol.mySqrt(4));
//        sol.test();

    }

}
