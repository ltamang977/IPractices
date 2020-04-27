package org.lv.ipractices.hackerrank;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.lang.Exception;
import java.util.Scanner;

public class Solution {
    public static String getDay(String day, String month, String year) {
        String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
                "Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYYYY");
            Date date = dateFormat.parse(day + month + year);


            calendar.set(Calendar.YEAR, Integer.parseInt(year));
            calendar.set(Calendar.MONTH, Integer.parseInt(month)-1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
            System.out.println(calendar.getTime());


        } catch (Exception pEx) {

        }
        return strDays[calendar.get(Calendar.DAY_OF_WEEK) - 1];
        /*
         * Write your code here.
         */

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}