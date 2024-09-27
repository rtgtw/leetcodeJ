package Leetcode.Strings;


import java.util.Arrays;
import java.util.HashSet;

//can store vowels in a set (distinct characters)
//Can iterate through and check if it contains
//MAX counter
//traverse counter
//two pointers to traverse

//sliding window??
public class MaxVowels1456 {


    public int maxVowels(String s, int k){

        //counters
        int maxCounter = 0;
        int traverseCounter = 0;


        //convert string to charArray
        char [] sToCharArray = s.toCharArray();

        //store vowels into a set, HashSet
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));


        for(int i = 0; i < sToCharArray.length; i++ ){
            if(maxCounter == k){
                return maxCounter;
            }

            if(vowels.contains(sToCharArray[i])){
                traverseCounter++;

            }

            if(i >= k){
                //time to slide the window
                if(vowels.contains(sToCharArray[i - k])){
                    traverseCounter--;
                }
            }

            maxCounter = Math.max(maxCounter,traverseCounter);
        }

        return maxCounter;

    }


    public static void main(String args[]){

        String s = "abciiidef";
        String s1 = "aeiou";
        int k = 3;
        int k1 = 2;

        MaxVowels1456 sol = new MaxVowels1456();
        System.out.println(sol.maxVowels(s,k));

    }



}
