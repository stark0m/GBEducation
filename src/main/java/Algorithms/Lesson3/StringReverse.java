package Algorithms.Lesson3;


import Algorithms.Lesson3.stack.StackImpl;
import Algorithms.Lesson3.stack.Stack;


public class StringReverse {
    public static String stringReverse(String string){
        int length = string.length();
        Stack<Character> stack = new StackImpl<>(length);
        for (int i = 0; i < length; i++) {
            stack.push(string.charAt(i));
            
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
        
    }
    
}
