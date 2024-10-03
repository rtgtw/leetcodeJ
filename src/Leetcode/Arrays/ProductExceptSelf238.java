package Leetcode.Arrays;

public class ProductExceptSelf238 {


    public int[] productExceptSelf(int [] nums){

        int length = nums.length;

        //Store final result
        int result[] = new int[length];

        //Create a left array to store the prefix product of each element
        int left[] = new int[length];

        //Creat ea right array to store the suffix product of each element
        int right[] = new int[length];

        //Traverse the input array forward from left to right to get the prefix product
        //for the leftmost element the prefix product is 1
        left[0] = 1;

        for(int i = 1; i < length; i++){
            left[i] = left[i -1] * nums[i-1];
        }

        //Traverse the right
        right[length - 1] = 1;

        //Traverse the input array backwards from right to left to get the suffix product
        for(int i = length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        //multiply left and right and store in result to get answer
        for(int i = 0; i < length; i++){
            result[i] = left[i] * right[i];
        }


        return result;

        //time complexity oN
        //space complexity oN
    }

    public int [] productOfSelfOpt(int [] nums){
        int length = nums.length;


        //Create a left array to store the prefix product of each element
        int left[] = new int[length];

        //create a right int variable to traverse backwards
        int right = 1;

        //Traverse the input array forward from left to right to get the prefix product
        //for the leftmost element the prefix product is 1
        left[0] = 1;

        for(int i = 1; i < length; i++){
            left[i] = left[i -1] * nums[i-1];
        }


        //Traverse the same left array backwards with hold a right variable for the suffix
        for(int i = length - 2; i >= 0; i--){
            //Obtain suffix
            right = right * nums[i+1];

            //update left[i]
            left[i] = left[i] * right;

            //can do *= but writing it out for learning purposes

        }


        return left;

    }


    public static void main(String args[]){

        int input[] = {1,2,3,4};

        ProductExceptSelf238 sol = new ProductExceptSelf238();

        for(int x : sol.productOfSelfOpt(input)){
            System.out.print(x + " ");
        }

    }
}
