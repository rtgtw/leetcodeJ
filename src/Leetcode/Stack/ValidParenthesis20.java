package Leetcode.Stack;


import java.util.Map;
import java.util.Stack;

//This is a stack problem
//Add open parenthesis to the stack, pop from stack when close is
//the immediate next one
//Return false if closed bracket is pushed to stack
public class ValidParenthesis20 {

    //We can do this in a clever way because the open brackets are the KEY, so if we check if
    //the map contains the key of the next value from String s, we can determine automatically if its
    //open, if it does not contain the key then it is not open
    private static final Map<Character, Character> parenthesisMap = Map.of('(',')',
                                                                           '{','}',
                                                                           '[',']');

    public boolean isValid(String s){
        //Create a stack data structure object
        Stack<Character> bracketStack = new Stack<>();

        //Iterate through String s, String is immutable so turn it into a char array
        for(char c : s.toCharArray()){

            if(parenthesisMap.containsKey(c)){
                //while iterating through the string, if the char == key its an open bracket, push to stack
                bracketStack.push(c);
            }
            //Now if this character is a closing bracket instead, its a value
            //if it contains a value, we then have to check if the top of the stack
            //is == to its key, if not return false, if true, pop the key from the stack
            //and bracketStack.peek (top of the stack) is equal to the values's KEY
            else if(parenthesisMap.containsValue(c) ){
                //
                if(bracketStack.isEmpty()){
                    return false;
                    //.get gets you the value
                    //.peek gets you they key
                }else if(parenthesisMap.get(bracketStack.peek()) == c)
                //pop it from the stack
                bracketStack.pop();
                else{
                    return false;
                }
            }


        }
        //if the stack is empty, return true
        return bracketStack.isEmpty();

    }

    public static void main(String args[]){
        ValidParenthesis20 sol = new ValidParenthesis20();
        String s = ("(])");

        System.out.println(sol.isValid(s));
        //time complexity o(n) iterating through char array
        //space complexity o(1?) map containing 6 values
        //stack o(n) can have up to n values potentially
    }




}
