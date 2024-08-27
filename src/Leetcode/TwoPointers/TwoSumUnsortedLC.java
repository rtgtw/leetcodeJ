package Leetcode.TwoPointers;

import java.util.HashMap;

/*
In order to solve two sum when the array is unordered, we are goign
to have to use a hashmap
time complexity = O(n) since we iterate through they array at least once
space complexity = O(n) since we create a hashmap that can store in
worst case scenario is everything inside of the array
space = how much memory is being consumed


CurrentVal + X = target

X = Target - CurrentVal

*/
public class TwoSumUnsortedLC {


    public int[] twoSum(int[] nums, int target){

        int [] result = new int[2];
        //Create the hashmap to store the values
        HashMap<Integer,Integer> map = new HashMap<>();

        //Iterate through the array
        for(int i = 0; i< nums.length; i++){
            //Through each iteration, check if there is a value in the hashmap + current value = target
            if(map.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                return result;
//                return new int[]{i,map.get(target - nums[i])};
            }else{
                //place the key-value (Value,Index) pair of currentValue
                map.put(nums[i],i);
            }
        }
        return result;
    }


    public static void main(String args[]){
        TwoSumUnsortedLC sol = new TwoSumUnsortedLC();

        int answer[] = sol.twoSum(new int[]{2,7,11,15},9);
        int answer2[] = sol.twoSum(new int[]{3,2,4},6);
        int answer3[] = sol.twoSum(new int[]{3,3},6);

        System.out.println(answer[0] + " " + answer[1]);
        System.out.println(answer2[0] + " " + answer2[1]);
        System.out.println(answer3[0] + " " + answer3[1]);
    }

}
