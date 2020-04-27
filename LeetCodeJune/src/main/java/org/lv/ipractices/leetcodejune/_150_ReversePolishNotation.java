package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _150_ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        if(tokens==null || tokens.length==0)
            return 0;

        List<String> expressions = Arrays.asList("/", "*", "+", "-");

        Stack<Integer> stack = new Stack();
        for(String token : tokens){
            if (expressions.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int c;

                if("/".equals(token)){
                    c = a/b;

                }else if("*".equals(token)){
                    c = a*b;

                }else if("+".equals(token)){
                    c = a+b;

                }else {
                    c = a-b;
                }
                stack.push(c);

            }else {
                stack.push(Integer.parseInt(token));
            }


        }

        return stack.pop();


    }

    public static void main(String[] args){

        String[] tokens = {"2", "1", "+", "3", "*"};
        int value = evalRPN(tokens);
        System.out.println(value);

    }
}
