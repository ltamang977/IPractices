package org.lv.ipractices.leetcodejune;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger_E {



    public static int romanToInteger(String roman){

        Map<Character,Integer> romanValue = new HashMap<>();
        romanValue.put('I', 1);
        romanValue.put('V', 5);
        romanValue.put('X', 10);
        romanValue.put('L', 50);
        romanValue.put('C', 100);
        romanValue.put('D', 500);
        romanValue.put('M', 1000);

        int value = 0;

        for(int i=0; i<roman.length(); i++){
            char c = roman.charAt(i);

            if(c=='I' || c=='X' || c=='C'){

                int j = i+1;
                if(j<roman.length() &&
                        ( (c=='I' && (roman.charAt(j)=='V'|| roman.charAt(j)=='X'))
                            || (c=='X' && (roman.charAt(j)=='L'|| roman.charAt(j)=='C'))
                            || (c=='C' && (roman.charAt(j)=='D'|| roman.charAt(j)=='M'))) ){

                    value+=romanValue.get(roman.charAt(j))-romanValue.get(c);
                    i=j;//jumt next char

                }else{
                    value+=romanValue.get(c);
                }

            }else {
                value+=romanValue.get(c);
            }
        }

        return value;

    }

    public static void main(String[] args){

        String input = "MCMXCIV";
        int value = romanToInteger(input);
        System.out.println("Integer value for roman "+input+" is :" + value);

    }
}
