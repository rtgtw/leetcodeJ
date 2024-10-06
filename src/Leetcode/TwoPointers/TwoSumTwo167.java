package Leetcode.TwoPointers;


public class TwoSumTwo167 {

    //Use a two pointers to solve this problem
    //its 1 indexed so add 1 after to get the proper index
    public static int[] twoSum(int[] numbers, int target){

        //Create left and right pointers
        int left = 0;
        int right = numbers.length - 1;
        int [] result = new int[2];

        //use a for loop to iterate through the array
        while(left < right) {
            if(numbers[left] + numbers[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
                //this means we have to bring right down
            }else if (numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }

        return result;
        //time complexity oN
        //space complexity o1
    }





    public static void main(String args[]){

        int nums[] = {2,7,11,15};
        int target = 9;

        for(int x : TwoSumTwo167.twoSum(nums,target)){
            System.out.print(x + " ");
        }

    }

}
