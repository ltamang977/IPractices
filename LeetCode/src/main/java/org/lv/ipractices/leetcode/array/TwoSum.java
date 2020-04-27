package org.lv.ipractices.leetcode.array;

/**
 * Created by root on 1/19/18.
 */

import java.util.Arrays;

import java.util.Map;
import java.util.HashMap;

import org.lv.ipractices.leetcode.tree.TreeNode;
public class TwoSum {

    /**
     * Two sum in regular array using HashMap.
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSum(int[] arr, int sum){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length;i++){
            int x= arr[i];
            int y = sum-x;//to find this
            if(map.containsKey(y)){
                return new int[]{map.get(y), i};
            }else{
                map.put(x, i);
            }

        }

        throw new IllegalArgumentException("Elements not found");

    }

    /**
     * Two sum in sorted array
     * @param arr
     * @param sum
     * @return
     */
    public static int[] twoSumSortedArray(int[] arr, int sum){

        for(int i=0; i<arr.length-1; i++){
            int x = arr[i];
            int y = sum-x;//looking

            int left = i+1;
            int right =arr.length-1;
            while(left<=right){
                int mid = left +(right-left)/2;

                if(arr[mid]==y){
                    return new int[]{i,mid};

                }else if(arr[mid]>y){
                    //go left
                    right = mid-1;
                }else if(arr[mid]<y){
                    //go right
                    left = mid+1;
                }
            }

        }
        throw new IllegalArgumentException("Elements not found");
    }


    //first solution

    /**
     * Two sum in binary tree
     * Solution 1:
     * @param root
     * @param sum
     * @return
     */
    public static boolean twoSumTree(TreeNode root, int sum){
        //need to two reference node, curr,,, sum-curr.value //look for this
        //need to go left and right
        return dfs(root, root, sum);

    }

    public static boolean dfs(TreeNode node, TreeNode curr, int sum){
        if(curr==null)
            return false;

        return search(node, curr, sum-curr.value)
                || dfs(node, curr.left,sum)
                || dfs(node, curr.right, sum);

    }

    public static boolean search(TreeNode node, TreeNode curr, int searchValue){
        if(node==null)
            return false;

        if(node.key==searchValue){
            return true;
        }else if(searchValue<node.key){
            return search(node.left,curr,searchValue);
        }else if(searchValue>node.key){
            return search(node.right, curr, searchValue);
        }
        return false;
    }


    public static boolean twoSumTreeSolution2(TreeNode root, int sum){
        return dfs2(root, root, sum);
    }

    public static boolean dfs2(TreeNode xNode, TreeNode yNode, int sum){

        if(xNode == null)
            return false;

        if(xNode!=yNode) {
            int searchValue = sum - xNode.key;//should match with YNode
            boolean flag = findValue(yNode, searchValue);
            if(flag)
                return true;
        }

        return dfs2(xNode.left, yNode, sum) || dfs2(xNode.right, yNode, sum);
    }

    public static boolean findValue(TreeNode node, int searchValue){
        if(node==null)
            return false;

        if(searchValue==node.key){
            return true;
        }else if (searchValue<node.key){
            return findValue(node.left, searchValue);
        }else if (searchValue>node.key){
            return findValue(node.right, searchValue);
        }
        return false;
    }



    public static void main(String[] args){

        int[] arr = {1,3,6,5,7,8,2};

        //twosum calculation in regular array
        //System.out.println("Two sum indexes are :"+Arrays.toString(twoSum(arr, 10)));

        //twosum calculation in sorted array
        //Arrays.sort(arr);
        //System.out.println("arrays content"+Arrays.toString(arr));
        //System.out.println("Two sum indexes are :"+Arrays.toString(twoSumSortedArray(arr, 9)));


        //two sum in tree
        TreeNode root = new TreeNode(5,2);
        root.insert(6,2);
        root.insert(3,2);
        root.insert(1,2);
        root.insert(7,2);
        root.insert(8,2);
        root.insert(2,2);

        root.inOrderTraversal(root);

        //two sum tree first solution
        //System.out.println("Check if two elements exists"+twoSumTree(root, 20));

        //two sum tree second solution
        System.out.println("Check if two elements exists in solution2"+twoSumTreeSolution2(root, 9));


    }
}
