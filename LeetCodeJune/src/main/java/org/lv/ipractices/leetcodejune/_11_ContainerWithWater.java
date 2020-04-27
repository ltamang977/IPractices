package org.lv.ipractices.leetcodejune;

public class _11_ContainerWithWater {


    public static int maxArea(int[] height) {


        int maxArea = 0;

        int left = 0;
        int right = height.length-1;

        while(left<right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return  maxArea;

    }


    public static void main(String[] args){

        int[] height = {1,2,1};

        System.out.println("Max area is :"+maxArea(height));

    }
}
