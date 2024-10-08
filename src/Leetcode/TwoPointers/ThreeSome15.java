package Leetcode.TwoPointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//needs to be sorted
//HashSet List of triplets, to hold results
//Just a mix of twosum
public class ThreeSome15 {

    public static List<List<Integer>> threeSum(int[] nums){
        //first thing we want to do is create a HashSet to store the triplets
        //but we have to return a List of lists so convert results into arraylist when returning

        //use an array list vs a hashset
        List<List<Integer>> results = new ArrayList<>();

        //Sort nums
        Arrays.sort(nums);

        //Create a for loop to iterate through nums, starting with the first value, and
        //ending - 2

        for(int i = 0; i < nums.length - 2; i++ ){


            //skip duplicates
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            if(nums[i] > 0){
                break;
            }

            //create a left and right pointer (2 pointer)
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    results.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;


                    //skip duplicates from the left pointer
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                    //skip duplicates from the right pointer
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }

            }

        }
        return results;

        //time complexity(n^2)
        //space complexity(n)
    }



    public static void main(String args[]){

        int [] nums = {-1,0,1,2,-1,-4};

        for(List<Integer> x : ThreeSome15.threeSum(nums)){
            System.out.println(x);
        }


    }
}
