package Leetcode.TwoPointers;


//Def use a hashmap to store the char, and have a counter to see if the counters equal each other

import java.util.Collection;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t){
        //Create hashmap
        //The key will be the character, the value will be the counter
        HashMap<Character,Integer> hm = new HashMap<>();

        //Store the character in the hashmap and increment the counter
        for(int i = 0; i < s.length(); i++){

            if(!hm.containsKey(s.charAt(i))){
                int currentValue = 0;
                hm.put(s.charAt(i),++currentValue);
            }else{

                int value = hm.get(s.charAt(i));
                value = value + 1;

                hm.put(s.charAt(i),value);
            }

            //Insert character into map

        }

        for(int i = 0; i < t.length(); i++){
            if(hm.containsKey(t.charAt(i))) {
                int currentValue = hm.get(t.charAt(i));
                currentValue = currentValue - 1;
                //subtract the counter now
                hm.put(t.charAt(i), currentValue);

                if (currentValue == 0) {
                    hm.remove(t.charAt(i));
                }
            }else{
                int currentValue = 0;
                hm.put(t.charAt(i),++currentValue);}
        }

        if(hm.isEmpty()){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        ValidAnagram sol = new ValidAnagram();

        System.out.println(sol.isAnagram("a","ab"));
//        System.out.println(sol.isAnagram("rat","car"));
    }
}
