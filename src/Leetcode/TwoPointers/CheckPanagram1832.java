package Leetcode.TwoPointers;

import java.util.HashMap;

public class CheckPanagram1832 {

    public boolean checkPanagram(String sentence){

        //Turn sentence into char array
        char sentenceArray[] = sentence.toCharArray();

        //Create array of alphabets
        char alphabets[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
                            't','u','v','w','x','y','z'};

        HashMap<Character,Integer> alphabet = new HashMap<>();

        //initialize hashmap to 0
        for(char x : alphabets){
            alphabet.put(x,0);
        }

        for(char x :sentenceArray){
            if(alphabet.containsKey(x)){
                alphabet.put(x,alphabet.get(x) + 1);
            }
        }

        return !alphabet.containsValue(0);


    }

    public static void main(String args[]){
        String string1 = "thequickbrownfoxjumpsoverthelazydog";
        String string2 = "leetcode";
        CheckPanagram1832 sol = new CheckPanagram1832();

        System.out.println(sol.checkPanagram(string2));
    }


}
