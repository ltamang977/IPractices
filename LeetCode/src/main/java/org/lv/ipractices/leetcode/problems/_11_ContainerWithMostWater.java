package org.lv.ipractices.leetcode.problems;


class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {


        int i=0;
        int j = height.length - 1;
        double maxArea = 0;

        while(i<j){

            int minHeight = Math.min(height[i],height[j]);
            maxArea = Math.max(maxArea, minHeight * (j-i));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return (int)maxArea;

    }
}
