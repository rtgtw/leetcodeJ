package Leetcode.Arrays;

import java.util.HashSet;

public class ConsecutiveSequence128 {


    public static int longestConsecutive(int nums[]){

        int n = nums.length;
        if (n == 0)
            return 0;
        //counter
//        int counter = 0;
        int maxCounter = 0;

        //Create a new set and convert nums array into set
        HashSet<Integer> numsHashSet = new HashSet<>();

        //initialize hashset
        for(int x : nums){
            numsHashSet.add(x);
        }



       //iterate through the set of numbers
        for(int num : numsHashSet){

            //check if its the start of the sequence
            if(!numsHashSet.contains(num - 1)){
                int currentNum = num;
                int counter = 1;

                //check for consecutive numbers
                while(numsHashSet.contains(currentNum + 1)){
                    currentNum++;
                    counter++;
                }
                maxCounter = Math.max(maxCounter, counter);
            }
        }

        return maxCounter;

    }






    public static void main(String args[]){

        int nums [] = {100,4,200,1,3,2};

        System.out.println(ConsecutiveSequence128.longestConsecutive(nums));


    }
}
