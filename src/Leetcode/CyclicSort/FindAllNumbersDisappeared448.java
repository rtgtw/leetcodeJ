package Leetcode.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared448 {


    public List<Integer> findDissapeared(int nums[]){
        //nums = [4,3,2,7,8,2,3,1]

        int i = 0;
        int swap;
        List<Integer> result = new ArrayList<>();
        //Use another for loop to check and push the index for the values that are no there
        while(i < nums.length){

            if(nums[i] != nums[nums[i] - 1] ){
                //swap
                //If there is a duplicate, it will still pass even tho its not in the right spot
                swap = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i] ;
                nums[i] = swap;

            }else{
                i++;
            }
        }

        for(int n = 0; n < nums.length; n++ ){
            if(nums[n] != n + 1){
                result.add(n+1);
            }

        }

        return result;
    }





    public static void main(String args[]){

        List<Integer> list = new ArrayList<>();

        FindAllNumbersDisappeared448 sol = new FindAllNumbersDisappeared448();

        list = sol.findDissapeared(new int[]{4,3,2,7,8,2,3,1});


        for(Integer x : list){
            System.out.print(x + " ");
        }
    }






}
