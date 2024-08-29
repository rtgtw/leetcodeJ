package Leetcode.TwoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s){
        //First we need to create a for loop to iterate through the string
        //Have two pointers, one starting at the beginning and one at the end
        //Both moving inwards, create a for loop to do this
        //Also check for non-character values and skip them
        for(int i = 0, j =s.length() - 1; i < j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                //increment i if it isnt a char
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }







    public static void main(String args[]){

        String input = "A man, a plan, a canal: Panama";
        String input2 = "race a car";
        String input3 = " ";
        ValidPalindrome sol = new ValidPalindrome();

        System.out.println(sol.isPalindrome(input3));
    }
}
