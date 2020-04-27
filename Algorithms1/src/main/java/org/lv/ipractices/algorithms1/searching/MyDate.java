package org.lv.ipractices.algorithms1.searching;


import java.lang.Comparable;

import java.util.Date;

/**
 * Created by root on 12/21/17.
 */
public final class MyDate implements Comparable<MyDate>  {

    private int day;
    private int month;
    private int year;


    public boolean equals(Object o){
        //1. check referencial equality
        if(this == o)
            return true;

        //2. check nullity
        if(o == null)
            return false;

        //check class
        if(this.getClass() != o.getClass())
            return false;

        Date that = (Date) o;
        if(this.day != that.getDay()) return false;
        if(this.month != that.getMonth()) return false;
        if(this.year != that.getYear()) return false;

        return true;
    }

    @Override
    public int compareTo(MyDate o) {
        return 0;
    }
}
