package Leetcode.Misc;


//XOR (exclusive OR, problem) (O(N) time complexity, O(1) space complexity)
public class SingleNumberXOR136 {


    public int singleNumber(int nums[]){
        //Pass in the nums array, iterating through it entirely, looking for the number that is single
        //Create an XOR counter starting at 0, if there are two duplicate numbers, it will get back to 0
        //if there is a single or prime number (should only be single) it will be that number b/c XOR

        //Create XOR counter
        int XORCOUNTER = 0;

        //Iterate through the array
        for(int x : nums){

            XORCOUNTER ^= x;
        }

        return XORCOUNTER;
    }


    public static void main(String args[]){
        SingleNumberXOR136 sol = new SingleNumberXOR136();


        int num[] = {4,1,2,1,2};
        System.out.println(sol.singleNumber(num));
    }
}
