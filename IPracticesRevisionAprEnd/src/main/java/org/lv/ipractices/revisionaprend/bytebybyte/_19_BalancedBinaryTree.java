package org.lv.ipractices.revisionaprend.bytebybyte;

public class _19_BalancedBinaryTree {



    public static boolean balancedBinaryTree(BinarySearchTree.TreeNode<Integer,String> root){

        if(root==null)
            return true;

        return balancedHeight(root)>-1?true:false;


    }

    public static int balancedHeight(BinarySearchTree.TreeNode<Integer,String> root){

        if(root==null)
            return 0;

        int leftHeight = balancedHeight(root.left);
        int rightHeight = balancedHeight(root.right);

        if(leftHeight==-1 || rightHeight==-1)
            return -1;

        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }


    public static void main(String[] args){

        BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();
        bst.put(11, "Something");

        System.out.println("Checking if binary search tree is balanced : "+balancedBinaryTree(bst.root));


    }
}
