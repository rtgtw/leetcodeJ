package Leetcode.Stack;

import java.util.Stack;

public class DailyTemperatures739 {

    static long o2time;
   static long ntime;

   static long optimizedn;
    public static int[] dailyTemperatureso2(int[] temperatures) throws Exception {
        long startTime = System.currentTimeMillis();
        long startTimeNano = System.nanoTime();

        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){

                if(temperatures[j] > temperatures[i]){
                    answer[i] = j - i;
                    break;
                }
            }
        }


        long endTime = System.currentTimeMillis();
        long endTimeNano = System.nanoTime();
        System.out.println("Duration of method was: " + (endTime - startTime) + " ms");
        System.out.println("Duration of method was: " + (endTimeNano - startTimeNano) + " ns");

        o2time = endTimeNano - startTimeNano;

        return answer;
    }

    public static int[] dailyTemperaturesON(int [] temperatures){
        long startTime = System.currentTimeMillis();
        long startTimeNano = System.nanoTime();

        int[] answer = new int[temperatures.length];

        //Create a stack
        Stack<Integer> temps = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){

            while(!temps.empty() && temperatures[i] > temperatures[temps.peek()]){
                answer[temps.peek()] = i - temps.peek();
                temps.pop();
            }

            if(!temps.empty() && temperatures[i] <= temperatures[temps.peek()]){

                //push it onto the stack by index
                temps.push(i);
            }

            if(temps.empty()) {
                temps.add(i);
            }

        }


        long endTime = System.currentTimeMillis();
        long endTimeNano = System.nanoTime();
        System.out.println("Duration of method was: " + (endTime - startTime) + " ms");
        System.out.println("Duration of method was: " + (endTimeNano - startTimeNano) + " ns");

        ntime = endTimeNano - startTimeNano;
        return answer;
    }




    public static int[] dailyTemperature(int [] temperatures){
        long startTime = System.currentTimeMillis();
        long startTimeNano = System.nanoTime();



        int[] answer = new int[temperatures.length];

        //Create a stack to hold indexes of values
        Stack<Integer> temps = new Stack<>();

        //iterate through array
        for(int i = 0; i < temperatures.length; i++){

            //while the stack is not empty and the current index is greater
            //than the previous index (top of the stack holds the prev index)
            //calculate the difference in indexes to get # of days
            //pop the prev index from the stack, keep doing this until you
            //get a value that is less than or equal to
            while(!temps.empty() && temperatures[i] > temperatures[temps.peek()]){
                answer[temps.peek()] = i - temps.peek();
                temps.pop();
            }

            //when you get something less than or equal to, just push it to the stack
            //this also initially gets triggered since we have an empty stack
            temps.push(i);

        }

        long endTime = System.currentTimeMillis();
        long endTimeNano = System.nanoTime();
        System.out.println("Duration of method was: " + (endTime - startTime) + " ms");
        System.out.println("Duration of method was: " + (endTimeNano - startTimeNano) + " ns");
        optimizedn = endTimeNano - startTimeNano;
        return answer;


    }

    public static void main(String args[])throws Exception{

        for (int x : DailyTemperatures739.dailyTemperatureso2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {

            System.out.print(x + " ");
        };

        System.out.println();
        System.out.println();
        System.out.println();


        for (int x : DailyTemperatures739.dailyTemperaturesON(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {

            System.out.print(x + " ");
        };

        System.out.println();
        System.out.println();
        System.out.println();


        for (int x : DailyTemperatures739.dailyTemperature(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {

            System.out.print(x + " ");
        };

        System.out.println();
        System.out.println(o2time);
        System.out.println(ntime);
        System.out.println(optimizedn);

    }
}

