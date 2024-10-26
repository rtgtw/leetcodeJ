package Leetcode.BinarySearch;

//Can try both solutions, brute force solution and binary search to add efficiency
/*

         With the brute force method the min number we can try is 1, because you
         coco have to eat at least one banana

         the max number of bananas to eat is the max within the pile,
         then we can start at the min and work our way until we find the first number
         that is equal to H

we can always round up(which is what we need to do)
    by doing (numerator + (denominator -1)) / denominator

 * */

public class KokoEatingBananas875 {

    public static int minEatingSpeedBruteForce(int piles[], int h){

        int maxPile = 0;

        int elapsedHours = 0;

        int k = 0;

        //iterate through the array and find the max value
        for(int i = 0; i < piles.length ; i++){
            maxPile = Math.max(maxPile, piles[i]);
        }

        //maxPile is the length of the for loop
        //when i = h, return i
        for(int i = 1; i <= maxPile; i++){

            for(int j = 0; j < piles.length; j++){
                k += (piles[j] +(i - 1))/i;
            }

            if(k == h){
                return i;
            }else{
                k = 0;
            }

        }
        return -1;
    }


    /*
    Binary search is based off the result of k,
    we are trying to get k = h, thats the adjustment we need to make

    */

    public static int minEatingSpeed(int[] piles, int h) {

        //we still need to find the maxPile
        int maxPile = 0;

        //iterate through piles to find the max pile
        for(int i = 0; i < piles.length; i++){
            maxPile = Math.max(maxPile, piles[i]);
        }

        //now that we have the max pile, 1 - maxPile are the potential number of
        //bananas coco can eat per hour, our goal is to find the lowest

        //Now we can do binary search, to find the lowest
        int low = 1;

        int high = maxPile;

        while(low < high){
            //Calculate the midPoint
            int midPoint = low + ((high - low) / 2);

            //k needs to be reset every iteration
            int k = 0;

            //perform the normal logic with the midPoint
            // (numerator + (denominator - 1)) / denominator
            //This is a ceiling formula

            //This for loop iterates through piles while adding each hour needed per pile to K
            for(int i = 0; i < piles.length; i++){
                k += (piles[i] + (midPoint - 1)) / midPoint;
            }

            //if K is less than or Equal to Hours
            //it essential means we are eating the bananas too fast and we need to go DOWN in bananas per hour
            //to do this we can set high to the midPoint, its not midPoint - 1 since the midPoint can potentially be the answer
            if(k <= h){
                high = midPoint;
                //if K is gerater than Hours then that means we are eating the bananas to SLOW and we need to go UP in bananas per hour
                //to do this we can set the low to midPoint + 1, since now we know the answer cant be our midPoint
            }else{
                low = midPoint + 1;
            }
        }

        //since the while loop is when low < high,
        //return low once we get out the while loop
        return low;

        //time MLog(N)
        //space 1
    }



    public static void main(String args[]){

        int piles [] = {312884470};
        int h = 312884469;

       // System.out.println(KokoEatingBananas875.minEatingSpeedBruteForce(piles,h));
       System.out.println(KokoEatingBananas875.minEatingSpeed(piles,h));
    }
}
