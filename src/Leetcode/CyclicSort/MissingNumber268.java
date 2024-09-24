package Leetcode.CyclicSort;

//Can do XOR or addition to solve this
public class MissingNumber268 {

    public int missingNumber(int nums[]){
        //Expected - Actual
        int expectedCounter = 0;
        int actualCounter = 0;
        for(int i = 0; i <= nums.length; i++){
            expectedCounter += i;
        }

        for(int i = 0; i < nums.length; i++){
            actualCounter += nums[i];

        }

        return expectedCounter - actualCounter;

        //time complexity o(n)
        //space complexity o(1)

    }


    public static void main(String args[]){
        int nums [] = {3,0,1};

        MissingNumber268 sol = new MissingNumber268();

        System.out.println(sol.missingNumber(nums));
    }
}
