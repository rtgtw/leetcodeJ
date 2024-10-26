package Leetcode.TwoPointers;


//To know how much water we can trap at every index (i)
/*

We have to know what is the max height of the left and right position
we can create an array to store the max height of the left position and the right position


* */



public class TrappingRainWater42 {


    public static int trapMemory(int elevation[]){

        int maxHeightLeft [] = new int[elevation.length];
        int maxHeightRight [] = new int[elevation.length];
        int minFromLeftAndRight[] = new int[elevation.length];

        int maxLeftCounter = 0;
        int maxRightCounter = 0;
        int waterSum = 0;

        //array for max left height
        for(int i = 1; i < elevation.length; i++){

            if(elevation[i - 1] > maxLeftCounter){
                maxLeftCounter = Math.max(maxLeftCounter, elevation[i - 1]);

                //we also want to store this value in elevation[i]
                maxHeightLeft[i] = maxLeftCounter;
            }else{
                maxHeightLeft[i] = maxLeftCounter;
            }
        }

        //array for max right height
        for(int i = elevation.length - 2; i >= 0; i--){
            if(elevation[i + 1] > maxRightCounter){
                maxRightCounter = Math.max(maxRightCounter, elevation[i + 1]);

                maxHeightRight[i] = maxRightCounter;
            }else{
                maxHeightRight[i] = maxRightCounter;
            }
        }

        //We need to take the minimum from both the maxLeft and the maxRight
        for(int i = 0; i < elevation.length; i++){

            //take the min and store it in minMaxArray
            minFromLeftAndRight[i] = Math.min(maxHeightLeft[i],maxHeightRight[i]);
        }


        //Now for every position we have to figure out how much water we can trap
        //to do this we can use by subtracting minFromLeftAndRight array index by elevation
        //so minFromLeftAndRight[i] - elevation[i], and if its less than 0 make it 0
        //then we add it all up
        for(int i = 0; i < elevation.length; i++){

            if(minFromLeftAndRight[i] - elevation[i] >= 0){
                waterSum += minFromLeftAndRight[i] - elevation[i];
            }

        }

        return waterSum;

        //Time oN
        //Space oN
    }


    //o1 memory
    //two pointers
    public static int trap(int [] elevation){

        int left = 1;
        int right = elevation.length - 2;
        int maxLeftSoFar = elevation[0];
        int maxRightSoFar = elevation[elevation.length - 1];
        int sum = 0;

        while(left <= right){

            //now we have the minimum from the max
            //we can subtract that by [i]
            if(maxLeftSoFar <= maxRightSoFar){

                if(maxLeftSoFar - elevation[left] >= 0) {
                    sum += maxLeftSoFar - elevation[left];
                }
                maxLeftSoFar = Math.max(maxLeftSoFar, elevation[left]);

                left++;
            }else{

                if(maxRightSoFar - elevation[right] >= 0){
                sum += maxRightSoFar - elevation[right];
        }
                maxRightSoFar = Math.max(maxRightSoFar, elevation[right]);

                right--;
            }
        }
        return sum;

        //optimized
        //time oN
        //space o1
    }



    public static void main(String args[]){
        int elevation[] = {4,2,0,3,2,5};

        System.out.println(TrappingRainWater42.trap(elevation));




    }
}
