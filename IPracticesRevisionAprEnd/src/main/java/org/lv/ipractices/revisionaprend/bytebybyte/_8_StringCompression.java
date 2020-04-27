package org.lv.ipractices.revisionaprend.bytebybyte;

public class _8_StringCompression {


    /*
    implementation checking diffent char
     */
    public static String compressStringCheckingDiff(String input){

        if(input == null || input.length()==0 || input.length()==1){
            return input;
        }
        char lastChar = input.charAt(0);
        int count = 1;

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i)!=lastChar){
                //append and reset
                sb.append(lastChar);
                sb.append(count);
                lastChar=input.charAt(i);
                count=1;
            }else {
                count++;
            }

        }
        sb.append(lastChar);
        sb.append(count);

        return sb.toString();

    }


    /*
        implementation checking diffent char
    */
    public static String compressStringCheckingSame(String input){

        if(input == null || input.length()==0 || input.length()==1){
            return input;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=0; i<input.length()-1; i++){
            if(input.charAt(i)==input.charAt(i+1)){
                count++;
            }else {
                sb.append(input.charAt(i));
                sb.append(count);
                count=1;
            }

        }
        sb.append(input.charAt(input.length()-1));
        sb.append(count);

        return sb.toString();

    }

    public static void main(String[] args){

        String s1 = "abbcccdddd";
        //System.out.println(compressStringCheckingDiff(s1));
        System.out.println(compressStringCheckingSame(s1));


    }
}
