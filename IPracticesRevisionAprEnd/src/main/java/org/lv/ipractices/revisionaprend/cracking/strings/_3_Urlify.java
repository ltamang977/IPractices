package org.lv.ipractices.revisionaprend.cracking.strings;

public class _3_Urlify {


    public static String urlify(char[] input, int size){

        int spaceCount = 0;
        for(int i=0; i<size; i++){
            if(input[i]==' ')
                spaceCount++;
        }

        int expandedSize = size + spaceCount * 2 ;

        for(int i=size-1; i>=0; i--){
            if(input[i]==' '){
                input[--expandedSize]='0';
                input[--expandedSize]='2';
                input[--expandedSize]='%';
            }else {
                input[--expandedSize]=input[i];
            }
        }

        return new String(input);

    }

    public static void main(String[] args){

        char[] input= {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        System.out.println("Urilified string is :"+urlify(input, 13));

    }
}
