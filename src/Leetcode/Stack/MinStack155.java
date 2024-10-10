package Leetcode.Stack;

import java.util.ArrayList;

public class MinStack155 {

    private ArrayList<Integer> stack;
    private ArrayList<Integer> minStack;
    public MinStack155(){

        //initialize both stacks
         stack = new ArrayList<>();
         minStack = new ArrayList<>();
    }


    public void push(int val){

        //the value to be pushed into the minStack
        if(stack.isEmpty()){
            minStack.addFirst(val);

            //Push the value onto the stack
            stack.addFirst(val);


        }else {

            //Push the value onto the stack
            stack.addFirst(val);

            //compare this new val, to the current addFirst in minStack and push the min
            val = Math.min(val, minStack.getFirst());
            minStack.addFirst(val);
        }
    }


    public void pop(){
        if(!stack.isEmpty()){
            stack.removeFirst();
            minStack.removeFirst();
        }

    }

    public int top(){
        if(!stack.isEmpty()){
            return stack.getFirst();
        }

        return -1;
    }


    public int getMin(){

        if(!minStack.isEmpty()){
            return minStack.getFirst();
        }


        return -1;
    }



    public static void main(String args[]){
        MinStack155 sol = new MinStack155();

        sol.push(-2);
        sol.push(0);
        sol.push(-3);
       System.out.println( sol.getMin());
       sol.pop();
       System.out.println(sol.top());
       System.out.println(sol.getMin());

        //time o1
        //space oN

    }

}
