package Leetcode.BinarySearch;


//Input: nums = [-1,0,3,5,9,12], target = 9
public class BinarySearch {


     public int search(int[] nums, int target){

         int low = 0;
         int high = nums.length - 1;


         while(low <= high){
             int midPoint = low + ((high - low) / 2);
             if(nums[midPoint] == target){
                 return midPoint;
             }else if(nums[midPoint] > target){
                 high = midPoint - 1;
             }else if (nums[midPoint] < target){
                 low = midPoint + 1;
             }
         }

         return -1;

     }


     public static void main(String args[]){
         BinarySearch sol = new BinarySearch();

         int nums[] = {-1,0,3,5,9,12};
         int nums1[] = {5};
         int target = 5;

         System.out.println(sol.search(nums1    , target));
     }
}
