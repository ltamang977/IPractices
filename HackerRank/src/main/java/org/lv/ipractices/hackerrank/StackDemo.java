package org.lv.ipractices.hackerrank;

import java.util.*;
class StackDemo{

    public static void main(String []argh)
    {

        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code

            for(int i=0; i<input.length(); i++){
                if(input.charAt(i)=='(' || input.charAt(i)=='{' || input.charAt(i)=='['){
                    stack.push(input.charAt(i));
                }else {
                    char ch = input.charAt(i);
                    char popCh = stack.pop();
                    if(ch==')' && popCh!='('){
                        System.out.println(false);
                        break;
                    } else if(ch=='}' && popCh!='{'){
                        System.out.println(false);
                        break;
                    } else if(ch==']' && popCh!='['){
                        System.out.println(false);
                        break;
                    }
                }
            }
            if(stack.size()>0){
                System.out.println(false);
            }else{
                System.out.println(true);
            }

            stack.clear();


        }

    }
}
