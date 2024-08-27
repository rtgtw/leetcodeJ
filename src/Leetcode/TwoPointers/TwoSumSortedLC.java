package Leetcode.TwoPointers;
import java.util.Arrays;
//Sort the array first
//then perform two pointers
public class TwoSumSortedLC {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{left,right};
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left--;
            }
        }

        return new int[]{left,right};
    }


    public static void main(String args[]){
        TwoSumSortedLC sol = new TwoSumSortedLC();

        int [] answer = sol.twoSum(new int[]{2,7,11,15},9);
        int [] answer2 = sol.twoSum(new int[]{3,2,4},6);
        int [] answer3 = sol.twoSum(new int[]{3,3},6);

        System.out.println(answer[0] + " " + answer[1]);
        System.out.println(answer2[0] + " " + answer2[1]);
        System.out.println(answer3[0] + " " + answer3[1]);
    }

}
