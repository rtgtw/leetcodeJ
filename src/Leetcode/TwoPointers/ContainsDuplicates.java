package Leetcode.TwoPointers;


import java.util.HashSet;

//Use a hashset to look for duplicates
public class ContainsDuplicates {
    public boolean containsDuplicates(int[]nums){
        //create hashset data structure
        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(hs.contains(nums[i])){
                return true;
            }else{
                hs.add(nums[i]);
            }
        }

        return false;
    }


    public static void main(String args[]){
        ContainsDuplicates sol = new ContainsDuplicates();

        int[] input = {1,2,3,1};

        System.out.println(sol.containsDuplicates(input));
    }


}
