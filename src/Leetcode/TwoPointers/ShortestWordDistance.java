package Leetcode.TwoPointers;

public class ShortestWordDistance {

    public int shortestDistance(String wordDict[], String word1, String word2){

        //Initialize word1 and 2's index location to -1, switch it if word was found
        int position1 = -1;
        int position2 = -1;

        //Initialize shortest distance, its initialized to the size of the array, we are looking for a low number
        int shortestDistance = wordDict.length;

        //Now we just iterate through the array in O(n) time, looking for both words, and calculating the distance
        for(int i = 0; i < wordDict.length; i ++){

            //While in this loop, with each iteration we want to look for both words to see if its at the index
            if(wordDict[i].equals(word1)){
                //change the index value of position 1
                position1 = i;
            }
            //same thing goes for word2
            if(wordDict[i].equals(word2)){
                position2 = i;
            }

            //Now within each iteration we just check to see if both positions were found and , calculate
            //if both positions were not found then we just move forward
            if(position1 != -1 && position2 != -1){

                //Now we have to check which of the two are the bigger number and make it first
                //we dont want a negative number thats why

                if(position1 > position2 && position1 - position2 < shortestDistance){
                    shortestDistance = position1 - position2;

                }

                if(position2 > position1 && position2 - position1 < shortestDistance){
                    shortestDistance = position2 - position1;
                }

            }

        }

        if(shortestDistance == wordDict.length){
            return -1;
        }else{
            return shortestDistance;
        }

    }



    public static void main(String args[]){
        ShortestWordDistance sol = new ShortestWordDistance();

        String wordDict[] = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        System.out.println(sol.shortestDistance(wordDict, word1,word2));

        //Time complexity O(N) - just iterating through the array
        //Space complexity O(1) we arent creating any data structures to handle the data
    }
}
