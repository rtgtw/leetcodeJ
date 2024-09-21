package Leetcode.SlidingWindow;



/*
*
* Find the max sum sub array of a fixed size k
* [4,2,1,7,8,1,2,8,1,0]
*
*
* */

public class SlidingWindowIntro {


    //takes in array and the size of the subarray k
    public static int findMaxSumSubarray(int array[], int k){
        //We need the current running sum, this is for each iteration
        //We need the max sum so far, which is the highest that is seen in total

        //Start off the max value to negative infinity
        int maxValue = Integer.MIN_VALUE;

        //Initialize current running sum to 0
        int currentRunningSum = 0;

        //First step for the sliding window is we have to grow the initial length to k
        //create a for loop that will iterate through the array once
        for(int i = 0; i < array.length; i++){
            //Add the value at index i to the current running sum
            currentRunningSum += array[i];

            //Ask the question: is the current running sum greater than the value currently recorded?
            //is the value of the index >= k - 1 (0 indexed), this allows us to see if we have reached k in the sliding window
            //Once we get to 3(k) elements, we need to compare the current running sum to the max value
            if(i >= k - 1){
                //once we enter this loop, we can officially start the sliding window
                //compare max value to currentrunningsum
                maxValue = Math.max(maxValue,currentRunningSum);

                //After this we have to iterate the sliding window forward, subtract the first element,
                //and add the next upcoming element
                currentRunningSum -= array[i - (k - 1)];
            }
        }

        //After we exit the loop return the max value
        return maxValue;

    }

    public static int smallestSubarray(int array[], int targetSum){

        //we want to return the size of the window
        int minWindowSize = Integer.MAX_VALUE;

        int currentWindowSum = 0;

        //Want a start and an end window
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            currentWindowSum += array[windowEnd];
            //we continue to iterate up until the point we are >= our targetSum
            //thats the minute you start to ask yourself, can i do better than this size?
            //then you would want to shrink your window
            while(currentWindowSum >= targetSum){
                //First you want to record and compare the size of the window to minWindow Size
                //+1 b/c 0 indexed
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= array[windowStart];
                windowStart++;
            }
        }

        //now we can just return the minimum window size
        return minWindowSize;
    }

    public static void main(String args[]){
//        System.out.println(findMaxSumSubarray(new int[]{4,2,1,7,8,1,2,8,1,0}, 3));

        int input[] = {4,2,2,7,8,1,2,8,10};
        int targetSum = 8;
        System.out.println(smallestSubarray(input,targetSum));


    }

}
