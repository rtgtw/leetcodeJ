package Leetcode.TwoPointers;

public class ReverseVowelOptimized {

    //method to check if the character is a vowel or not
    private boolean isVowel(char c){
        return c== 'a' || c== 'e' ||c== 'i' || c== 'o' ||c== 'u' ||
                c== 'A' ||c== 'E' || c== 'I' ||c== 'O' ||c== 'U';
    }



    //Now we can create the method to swap the vowels using a two pointer approach
    public String reverseVowels(String s){

        //First convert the string into a character array
        char sCA[] = s.toCharArray();

        //Initialize left and right pointers
        int left = 0;
        int right = sCA.length - 1;

        //Use a while loop to scan thru the array until left > right
        while(left < right){

            //if left does not equal a vowel then move to the next index
            while(left < right && !this.isVowel(sCA[left])){
                left++;
            }

            //if right does not equal a vowel then move to the next index
            while(left < right && !this.isVowel(sCA[right])){
                right--;
            }

            //swap the two
            if(left < right && isVowel(sCA[left]) && isVowel(sCA[right])){
                char swap = sCA[left];
                sCA[left] = sCA[right];
                sCA[right] = swap;
                left++;
                right--;
            }

        }

        //turn sCA back into a String
        //In order to do this correctly, you need to create a new string object to pass the char array
        return new String(sCA);
    }



    public static void main(String args[]) {
        String s = "hello";
        String b = "leetcode";
        ReverseVowelOptimized sol = new ReverseVowelOptimized();

        String solu = sol.reverseVowels(b);

        System.out.println(solu);

        //Time complexity O(N) iterating through the array once
        //Space complexity O(N) we have to convert string -> char array in java

    }

}

