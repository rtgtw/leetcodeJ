package Leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation150 {


    public static int evalRPN(String[] tokens){

        Stack<Integer> stack = new Stack<>();

        for(String x: tokens){


            if(x.equals("*")){
                //two values are in the stack, pop them both and multiply them
                stack.push(stack.pop() * stack.pop());

            }
            else if(x.equals("+")){
                stack.push(stack.pop() + stack.pop());

            }
            //they are placed flip flopped
            else if(x.equals("-") ){

               int a = stack.pop();
               int b = stack.pop();
               stack.push(b - a);
            }
            else if(x.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);


            }else{
                //type cast character and turn it into digit
                stack.add(Integer.parseInt(x));
            }
        }


        return stack.peek();
    }


    public static void main(String args[]){

        String tokens [] = {"2","1","+","3","*"};
        String tokens2 [] = {"4","13","5","/","+"};

        System.out.println(ReversePolishNotation150.evalRPN(tokens2));
    }
}
