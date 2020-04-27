package org.lv.ipractices.leetcode.linkedlist;

import org.lv.ipractices.leetcode.tree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by root on 1/28/18.
 */
public class FlattenBinaryTreeToLinkedLists {



    public static TreeNode flatten(TreeNode root){

        if(root==null)
            return root;

        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);

        if(left==null){
            return root;

        }else if (right == null){
            root.right = root.left;
            root.left = null;
            return root;

        }else {
            TreeNode temp = root.right;
            root.right = left;
            while(left.right!=null){
                left = left.right;
            }
            left.right=temp;
            return root;
        }

    }

    public static void printAsLinkedList(TreeNode root){
        System.out.println("Printing linked list");
        while(root!=null){
            System.out.println(root.key);
            root = root.right;
        }

    }



    public static void main(String[] args){

        TreeNode root = new TreeNode(1,1);
        root.insert(2,2);
        root.insert(3,3);
        root.insert(4,4);
        root.insert(5,5);
        root.insert(6,6);

        //root.inOrderTraversal(root);

        TreeNode list = flatten(root);
        list.inOrderTraversal(list);
        //printAsLinkedList(list);

    }
}
