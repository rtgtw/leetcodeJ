package Leetcode.TwoPointers;


import Leetcode.Arrays.ConsecutiveSequence128;

//Use a two pointer method to iterate through each height in the area
public class ContainerMostWater15 {
    public static int maxArea(int height[]){

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){

            //calculate the area of the container,
            //area = L * W
            //L = min of height[left] or height[right]
            //W = right - left
            int area = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,area);

            if(height[left] > height[right]){
                right--;
            }else{ left++;}

        }
        return maxArea;
    }

    public static void main(String args[]){

        int height[] = {8,7,2,1};

        System.out.println(ContainerMostWater15.maxArea(height));
    }
}
