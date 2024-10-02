package Leetcode.Arrays;


import java.util.ArrayList;
import java.util.List;

public class EncodeDecode271 {


    public String encode(List<String> strs){

        //Delimiter
        String delimeter = "|";

        //Create a list of StringBuilder
        List<StringBuilder> sbList = new ArrayList<>();

        //Converting String -> String Builder w/ delimiter
        for(String x : strs){
            sbList.add(new StringBuilder(x).append(delimeter));
        }

        //Create one more string builder to append all strings in sbList
        StringBuilder concatinatedSB = new StringBuilder();

        //String is encoded and delimited w/ pipe |
        for(StringBuilder x : sbList){
            concatinatedSB.append(x);
        }

        return concatinatedSB.toString();
    }


    public List<String> decode(String s){


        //specify delimiter
        String delimiter = "|";
        //Use String builder to store string in parameter
        StringBuilder incomingStringToSB = new StringBuilder(s);

        //We also have to create a List<StringBuilder>
        // to store the values and convert them back to string after
        List<StringBuilder> convertedSBList = new ArrayList<>();

        //Start and end to iterate through the encoded string
        int start = 0;
        int end = incomingStringToSB.indexOf(delimiter);

        //use a while loop to iterate through the delimiter and stop when its done?
        //-1 means its done
        while(end != -1){

            convertedSBList.add(new StringBuilder(incomingStringToSB.substring(start,end)));

            //change the start and the end to continue the iteration
            //end holds the index that the delimiter was at the delimiter length
            //which takes you to the beginning of the next available string
            //the new end would be the next delimited value
            //indexOf(Stirng str, int fromIndex, we replace start with the fromIndex,
            //in order to get to the next delimiter
            start = end + delimiter.length();
            end = incomingStringToSB.indexOf(delimiter,start);

        }

        //convert SBList to string list
        List<String> sbToStringList = new ArrayList<>();

        for(StringBuilder x : convertedSBList){
            sbToStringList.add(x.toString());
        }

        return sbToStringList;
    }



    public static void main(String args[]){
        EncodeDecode271 sol = new EncodeDecode271();
        List<String> sbList = new ArrayList<>(List.of("Hello","This","Is","An","Example"));


        System.out.println(sol.encode(sbList));
        System.out.println(sol.decode(sol.encode(sbList)));

        //time complexity - oN
        //space complexity oN
    }
}
