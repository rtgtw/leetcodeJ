package Leetcode.SlidingWindow;


import java.util.HashSet;

public class LongestSubstringChar3 {

    public static int lengthOfLongestSubstring(String s){
        int substringCounter = 0;
        int maxSubstring = 0;
        //Sliding window should shift dynamically
        int windowStart = 0;

        //hashset look for repeats
        HashSet<Character> set = new HashSet<>();
        //turn string into char array
        char stringToChar[] = s.toCharArray();

        if(stringToChar.length < 1){
            return 0;
        }else if(stringToChar.length == 1){
            return 1;
        }
        for(int windowEnd = 0; windowEnd < stringToChar.length; windowEnd++){
            if(windowEnd == 0){
                set.add(stringToChar[windowEnd]);
                substringCounter++;
                maxSubstring++;
                continue;
            }

            if(!set.contains(stringToChar[windowEnd])){

                substringCounter++;
                set.add(stringToChar[windowEnd]);
                maxSubstring = Math.max(maxSubstring, substringCounter);
                continue;

            }

            while(set.contains(stringToChar[windowEnd])){
                if(stringToChar[windowStart] == stringToChar[windowEnd]){
                    set.remove(stringToChar[windowStart]);
                }
                //repeating, move forward
                windowStart++;

            }


        }

        return maxSubstring;

    }


    public static void main(String args[]){
        String s = "abcabcbb";


        System.out.println(lengthOfLongestSubstring(s));
    }
}
