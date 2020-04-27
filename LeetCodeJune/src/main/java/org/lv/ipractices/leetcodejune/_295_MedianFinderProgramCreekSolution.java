package org.lv.ipractices.leetcodejune;

import java.util.Collections;
import java.util.PriorityQueue;

public class _295_MedianFinderProgramCreekSolution {



    static class MedianFinder {

       PriorityQueue<Integer> maxHeap;
       PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();

        }

        public void addNum(int num) {

            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if(maxHeap.size()<minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }


        }

        public double findMedian() {

            if(maxHeap.size()==minHeap.size()){
                return ((double)(maxHeap.peek()+minHeap.peek()))/2;

            }else{
                return maxHeap.peek();

            }


        }

    }
}
