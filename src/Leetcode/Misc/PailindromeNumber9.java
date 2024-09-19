package Leetcode.Misc;

public class PailindromeNumber9 {

    public boolean isPalindrome(int x){

        int y = x;

        int revertedNumber = 0;

        if(y < 0){
            return false;
        }

        while(y != 0){

            revertedNumber = revertedNumber * 10 + y % 10;
            y = y / 10;
        }


        if(x == revertedNumber){
            return true;
        }else{
            return false;
        }


    }

    public static void main(String args[]){
        PailindromeNumber9 sol = new PailindromeNumber9();

        System.out.println(sol.isPalindrome(12121));

    }
}
