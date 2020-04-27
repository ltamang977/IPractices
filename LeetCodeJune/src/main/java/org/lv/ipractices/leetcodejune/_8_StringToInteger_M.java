package org.lv.ipractices.leetcodejune;

public class _8_StringToInteger_M {

    public int atoi(String input){

        int i = 0;
        //avoding white spaces
        while(i<input.length() && input.charAt(i)==' '){
            i++;
        }

        boolean isNegative = false;
        if(i<input.length() && input.charAt(i)=='-'){
            isNegative=true;
        }

        if(i<input.length() && (input.charAt(i)=='-' || input.charAt(i)=='+')){
            i++;
        }

        //check for non digit chars
        if(i<input.length() && ((input.charAt(i)-'0'<0) || (input.charAt(i)-'0'>9))){
            return 0;
        }

        int j = i;
        int intVal = 0;
        while(j<input.length()){

            if(((input.charAt(j)-'0'>=0) &&  (input.charAt(j)-'0'<=9))){
                int temp = intVal*10+input.charAt(j)-'0';
                if(temp/10!=intVal){
                    if(isNegative){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
                intVal=temp;
                j++;

            }else {
                break;
            }


        }
        if(isNegative){
            return -intVal;
        }

        return intVal;


    }

    public static void main(String[] args){
        _8_StringToInteger_M sol = new _8_StringToInteger_M();

        String input = "3.14159";
        int result = sol.atoi(input);

        System.out.println("The integer valud of "+input+ " is "+result);

    }
}
