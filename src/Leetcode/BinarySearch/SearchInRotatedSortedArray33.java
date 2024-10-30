package Leetcode.BinarySearch;

//we are going to perform a binary search
//if L <= M, midpoint is in the leftSide of the pivot
//the key here is that this array is sorted in ascending order, even if it gets split
//we use this fact to create an algorithm

public class SearchInRotatedSortedArray33 {



    public static int search(int nums[], int target){
        int left = 0;
        int right = nums.length - 1;


        while(left <= right){

            //determine the midpoint
            int midPoint = (left + right) / 2;

            //first case, if nums[midPoint] == target, return midPoint
            if(nums[midPoint] == target){
                return midPoint;
            }

            //we have to check whether nums[midPoint] is on the left or right side of the pivot
            //{1,2,3,4,5,6,7,0}
            //if our midPoint was 7
            //if L(4) is less than or equal to M(7), its apart of the left side
            //This is true, which means 7 is apart of the left side
            //Second case: if our midPoint was 1
            //if L(4) is less than or equal to M(1), its apart of the left side
            //This is false, which means 1 is apart of the right side

            //This means the midPoint is apart of the left side
            if(nums[left] <= nums[midPoint]){
                //if the target is less than the midpoint but greater than the left pointer
                // then we stay in the left side
                //if the target is less than the midpoint and less than the left pointer
                //then we go the to the right side in a binary search

                //go right
                if(target < nums[left] || target > nums[midPoint]){
                    left = midPoint + 1;
                }else{
                    right = midPoint;
                }
                //this means the midPoint is apart of the right side
            }else{
                //{1,2,3,4,5,6,7,0}
                //we have to go to the left
                if(target > nums[right] || target < nums[midPoint]){
                    right = midPoint - 1;
                }else{
                    left = midPoint;
                }
            }

        }

        return -1;

        //time o(logN)
        //space 1
    }



    public static void main(String args[]){
        int nums []= {4,5,6,7,0,1,2};
        int nums2 [] = {};
        int target = 0;
        int target2 = 3;

        System.out.println(SearchInRotatedSortedArray33.search(nums,target2));


    }
}
