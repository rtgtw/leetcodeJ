package Leetcode.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {


    public List<List<String>> groupAnagrams(String [] strs) {
        //Create a map to store the key/value pair of the sorted values
        HashMap<String, List<String>> map = new HashMap<>();

        //turn string into char array then store it, so it doesnt change it
        for (String x : strs) {
            char[] temp = x.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);


            //Initialize the value section with a list, before adding stuff there
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(x);

            //push sorted
         }

        return new ArrayList<>(map.values());
        //time (nlogn)
        //space (n)
    }



    public static void main(String args[]){
        ArrayList<String>  input = new ArrayList<>(List.of());

        String inputs [] = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams49 sol = new GroupAnagrams49();

        System.out.println(sol.groupAnagrams(inputs));


    }



}





