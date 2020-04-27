package org.lv.ipractices.leetcodejune;

import java.util.Stack;

public class _32_LongestValidParethesis {



    public static int longestValidParentheses(String s) {


        Stack<Character> stack = new Stack<>();

        int max = 0;
        int currMax=0;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c==')'){
                if(stack.isEmpty() || stack.pop()!='('){
                    currMax=0;//reset
                }else {
                    currMax+=2;
                    max = Math.max(max, currMax);
                }

            }else {
                stack.push(c);
            }
        }

        return max;

    }

    public static void main(String[] args){
        //String s = "(()";
        String s = ")()())";
        int length = longestValidParentheses(s);

        System.out.println("The length is :"+length);
    }




}
