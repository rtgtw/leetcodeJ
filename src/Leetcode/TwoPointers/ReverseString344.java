package Leetcode.TwoPointers;


//reverse string, just swap until left > right
public class ReverseString344 {

    public void reversString(char s[]){

        //initialize pointers
        int left = 0;
        int right = s.length - 1;

        while(left < right){

            //Just swap then increment
            char swap = ' ';

            swap = s[left];
            s[left] = s[right];
            s[right] = swap;

            //swapped now we increment
            left++;
            right--;
        }


        System.out.println(s);

    }

    public static void main(String args[]){
        ReverseString344 sol = new ReverseString344();
        sol.reversString(new char[] {'h','e','l','l','o'});
    }
}
