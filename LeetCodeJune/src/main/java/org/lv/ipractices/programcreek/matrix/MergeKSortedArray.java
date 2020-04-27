package org.lv.ipractices.programcreek.matrix;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArray {


    class QueueNode implements Comparable<QueueNode>{
        int arrayIndex;
        int elementIndex;
        int value;

        public QueueNode(int arrayIndex, int elementIndex,  int value){
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
            this.value = value;

        }

        @Override
        public int compareTo(QueueNode o) {
            if(this.value<o.value)
                return -1;
            if(this.value>o.value)
                return 1;
            return 0;
        }
    }



    public int[] mergeKSortedArray(int[][] arrays){

        PriorityQueue<QueueNode> priorityQueue = new PriorityQueue<>();


        int total = 0;
        for(int i=0; i<arrays.length; i++){
            total+=arrays[i].length;
            priorityQueue.add(new QueueNode(i, 0, arrays[i][0]));
        }

        int[] result = new int[total];
        //or we can use if queue.isEmpty check
        for(int i = 0; i<total; i++){
            QueueNode node = priorityQueue.poll();
            result[i]=node.value;
            int nextIndex = node.elementIndex+1;
            if(nextIndex<arrays[node.arrayIndex].length){
                priorityQueue.add(new QueueNode(node.arrayIndex, nextIndex, arrays[node.arrayIndex][nextIndex]));
            }
        }

        return result;

    }


    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        MergeKSortedArray sol = new MergeKSortedArray();

        int[] result = sol.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}
