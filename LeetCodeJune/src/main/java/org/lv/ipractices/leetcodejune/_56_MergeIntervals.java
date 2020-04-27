package org.lv.ipractices.leetcodejune;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
   }

    public List<Interval> merge(List<Interval> intervals) {

        if(intervals==null || intervals.size()==0){
            return intervals;
        }

        intervals.sort(new Comparator<Interval>(){
            @Override
            public int compare(Interval m1, Interval m2){
                return m1.start-m2.start;
            }
        });

        List<Interval> resultList = new ArrayList<>();

        Interval old= intervals.get(0);

        for(int i=1; i<intervals.size(); i++){

            Interval curr = intervals.get(i);
            //merge meetings
            if(old.end>=curr.start){
                //merge
                old = new Interval(old.start, Math.max(old.end, curr.end ));

            }else{
                resultList.add(old);
                old = curr;
            }
        }
        resultList.add(old);

        return resultList;




    }
}
