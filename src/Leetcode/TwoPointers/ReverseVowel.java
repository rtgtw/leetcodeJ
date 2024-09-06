package Leetcode.TwoPointers;

//To solve this problem, we need a method to check if the character are vowels (lower and uppercase)
//We need to create a method to swap pointer1 and pointer2
//We need to convert the string to a character array since strings are immutable


public class ReverseVowel {

    //method to check if the character is a vowel or not
    private boolean isVowel(char c){
        return c== 'a' || c== 'e' ||c== 'i' || c== 'o' ||c== 'u' ||
                c== 'A' ||c== 'E' || c== 'I' ||c== 'O' ||c== 'U';
    }

    //method to swap values
    //arrays/objects are pass by value but you are passing the reference (pointer)
    private void swap(char ca[] , int a, int b){
        //create swap variable
        char swap = ca[a];
        ca[a] = ca[b];
        ca[b] = swap;
        System.out.println("Swapped " + ca[b] + " and " + ca[a]);
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
            if(!this.isVowel(sCA[left])){
                left++;
            }

            //if right does not equal a vowel then move to the next index
            if(!this.isVowel(sCA[right])){
                right--;
            }

            //swap the two
            if(isVowel(sCA[left]) && isVowel(sCA[right])){
                this.swap(sCA,left,right);
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
        ReverseVowel sol = new ReverseVowel();

        String solu = sol.reverseVowels(b);

        System.out.println(solu);

    }

}
