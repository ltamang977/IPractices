package org.lv.ipractices.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        /* Enter your code here.
        Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        List<List<Integer>> allList = new ArrayList<>();
        for(int i=0; i<times; i++){
            int elements = scanner.nextInt();
            List<Integer> elementList = new ArrayList<>();
            for(int j=0; j<elements; j++){
                elementList.add(scanner.nextInt());
            }
            allList.add(elementList);
        }

        int queries = scanner.nextInt();
        for(int i=0; i<queries; i++){
            int row = scanner.nextInt();
            int col = scanner.nextInt();


            List<Integer> selectedRow = allList.get(row-1);
            if(col<=selectedRow.size()){
                Integer val = selectedRow.get(col-1);
                System.out.println(val);
            }else {
                System.out.println("ERROR!");
            }
        }
    }
}