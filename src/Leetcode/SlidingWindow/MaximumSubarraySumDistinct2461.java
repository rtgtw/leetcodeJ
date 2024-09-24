package Leetcode.SlidingWindow;


import java.util.HashSet;

public class MaximumSubarraySumDistinct2461 {

    public static long maximumSubarraySum(int nums[], int k){
        //Create a hashset to store values and check for duplicates
        HashSet<Integer> duplicates = new HashSet<>();

        //max value
        int maxValue = Integer.MIN_VALUE;

        //counter to sum of k
        int sumOfValues = 0;

        int windowStart = 0;

        //for loop to iterate through nums
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++){

            //check if element is inside of duplicates
            while(duplicates.contains(nums[windowEnd])){
                //subtract i from the counter
                //remove the duplicate
                sumOfValues -= nums[windowStart];
                if(nums[windowEnd] == nums[windowStart]){
                    duplicates.remove(nums[windowStart]);
                }
                windowStart++;

            }
            //place element in set
            duplicates.add(nums[windowEnd]);


            //increment sumOfValues
            sumOfValues += nums[windowEnd];

            if(windowEnd - windowStart + 1 == k){
                maxValue = Math.max(maxValue, sumOfValues);

                duplicates.remove(nums[windowStart]);
                sumOfValues -= nums[windowStart];
                windowStart++;
            }


        }

        return maxValue;

    }


    public static void main(String args[]){
        int nums[] = {1,5,4,2,9,9,9};
        int k = 3;

        System.out.println(maximumSubarraySum(nums,k));
    }
}
