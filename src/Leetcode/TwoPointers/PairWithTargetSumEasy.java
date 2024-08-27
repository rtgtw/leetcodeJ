package Leetcode.TwoPointers;
import java.lang.*;

/*
Initialize the two pointers, left and right
Loop until the pointers meet (until left is less than right)
Calculate the current sum
Check if the current sum is equal to the target
return default values {-1,1} if nothing was found

Two methods, main method and method to calculate result in the class

 */

class Solution{

    //solution method, returns int array
    //passing in the int array and targetsum from problem
    public int[] search(int[] array, int targetSum){
        //initialize a new int array object
        int[] answer = {-1,1};


        //Constant time O(1)
        //initialize pointers
        int left = 0;
        int right = array.length - 1;

        //O(N)
        //loop until left index is less than right index, or value?
        while(left < right){
            //if statement to check if left value + right value = targetSum
            if(array[left] + array[right] == targetSum){
                answer[0] = left;
                answer[1] = right;
                return answer;
            }else if(array[left] + array[right] > targetSum){
                //bring down the value, decrement right pointer
                right--;
            }else{
                left++;
            }
        }

        //if nothing is found then return default -1,1
        return answer;
    }
}


public class PairWithTargetSumEasy {

    public static void main(String args[]){
        //Create solution array + targetSum
        int[] solutionArray = {1, 2, 3, 4, 6};
        int targetSum = 6;

        //Create instance(object) of solution
        Solution sol = new Solution();

        //Pass in solution array and targetSum
        int[] answer = sol.search(solutionArray,targetSum);

        //Print result
        System.out.println("["+ answer[0] + "," + answer[1] + "]");

        //Time complexity O(N)
        //Space complexity O(1)
    };
}
