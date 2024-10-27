package Leetcode.BinarySearch;


//   {3,4,5,1,2};

//if the mid section is greater than left, we want to go right
//if the mid section is less than left, we want to keep going left
//if the left pointer is less than the right pointer, then that means we are
//in a normal sorted positon and we can compare the current result to left and return min
public class FindMinInRotatedSortedArray153 {
    public static int findMin(int nums[]){

        //initialize result with the any value within the array
        int result = nums[0];

        //initialize left and right pointers
        int left = 0;
        int right = nums.length - 1;


        while(left <= right){
            //calculate the midPoint
            int midPoint = (left + right) / 2;

            //check if the leftmost value is less then the rightmost value
            if(nums[left] < nums[right]){
                //compare result with the leftmost and return the result
                return result = Math.min(result, nums[left]);
            }

            //binary search with conditions for rotated array

            //midPoint > left. Go right {3,4,5,1,2};
            if(nums[midPoint] >= nums[left]){
                result = Math.min(result,nums[midPoint]);
                left = midPoint + 1;
            }//or else go left
            else{
                result = Math.min(result,nums[midPoint]);
                right = midPoint - 1;
            }

        }
        return result;
        //time o(logN)
        //space 1
    }






    public static void main(String args[]){

    int nums[] = {3,4,5,1,2};

    System.out.println(FindMinInRotatedSortedArray153.findMin(nums));
    }
}
