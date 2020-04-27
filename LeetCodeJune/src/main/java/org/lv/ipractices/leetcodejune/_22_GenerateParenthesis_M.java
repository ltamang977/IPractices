package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParenthesis_M {

    public static List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<>();
        dfs(resultList, "", 0, 0,  n);
        return resultList;

    }


    public static void dfs(List<String> resultList, String str, int left, int right, int n){

        if(left==n && right==n){
            resultList.add(str);
            return;
        }

        if(left<n){
            dfs(resultList, str+'(', left+1, right, n);
        }

        if(right<left){
            dfs(resultList, str+')', left, right+1, n);
        }

    }

    public static void main(String[] args){

        List<String> resultList = generateParenthesis( 3);
        resultList.stream().forEach(System.out :: println);

    }
}
