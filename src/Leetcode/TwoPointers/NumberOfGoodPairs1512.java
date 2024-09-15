package Leetcode.TwoPointers;
import java.util.HashMap;

public class NumberOfGoodPairs1512 {

    static int numIdenticalPair(int nums[]){
        //[6,2,6,1,4,6,6,7]
        //initialize answer (holds total number of good pairs) with 0
        int answer = 0;

        //Declare HashMap
        //We are going to use the hashmap as a count, which tracks the index value as the key
        //and occurrences as the value
        HashMap<Integer, Integer> count = new HashMap<Integer,Integer>();

        //We can use a single for-loop to iterate through nums, for each value,
        //we are updating answer, if an index value has not been seen, update answer w/ 0,
        //however if it has been seen then update it with that value in answer, then increment
        //the hashmap value by 1 to signify this value has been seen

        for(int i = 0; i < nums.length; i++){
            //Update answer, and account for edge case if value has not been seen yet
            //can use += but will write it out for learning purposes
            answer = answer + count.getOrDefault(nums[i],0);

            //After updating answer we want to increment the value inside of the hashmap
            //Key = Current index's value
            //Value = value inside of the hashmap
            count.put(nums[i],count.getOrDefault(nums[i],0) + 1);
        }

        return answer;
    }

    public static void main(String args[]){
        int nums[] = {1,2,3,1,1,3};

        System.out.println(NumberOfGoodPairs1512.numIdenticalPair(nums));


        //Time complexity: O(N) iterating through an array once
        //Space complexity: O(n) storing n elements in a hashmap
    }

}
