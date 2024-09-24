package Leetcode.CyclicSort;



public class CyclicSortIntro {

    //return the array in a sorted order
    public int[] sort(int nums[]){

        //iterate through the array and swap for loop to iterate through the array
        //while loop to not move from the index until its at the correct position
        for(int i = 0; i < nums.length; i++){

            //create a variable to swap
            //{2,6,4,3,1,5}
            int swap;
            while(nums[i] != i+1){

                //hold the value of where 2 is going (6)
                //its 0 indexed so you have to subtract 1
                swap = nums[nums[i] - 1];

                //insert the correct value (2)
                nums[nums[i] - 1] = nums[i];

                //insert the value from swap in current index
                nums[i] = swap;
            }
        }

        return nums;

    }


    public static void main(String args[]){

        int[] nums = {2,6,4,3,1,5};

        CyclicSortIntro sol = new CyclicSortIntro();

       int[] solArr =  sol.sort(nums);

       for(int i = 0; i < solArr.length; i++){
           System.out.print(solArr[i] + " ");
       }



    }
}
