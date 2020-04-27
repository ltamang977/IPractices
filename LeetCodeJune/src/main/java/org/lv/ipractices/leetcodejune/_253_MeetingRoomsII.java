package org.lv.ipractices.leetcodejune;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _253_MeetingRoomsII {


    class Interval{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }


    public int countConferenceRooms(_252_MeetingRooms.Interval[] intervals) {

        if(intervals==null || intervals.length==0){
            return 0;
        }

        Arrays.sort(intervals, (i1, i2)->i1.start-i2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);

        int count = 1;
        for(int i=1; i<intervals.length; i++){

            if(intervals[i].start<pq.peek()){
                count++;

            }else{
                pq.poll();
            }

            pq.offer(intervals[i].end);


        }

        return count;

    }


}
