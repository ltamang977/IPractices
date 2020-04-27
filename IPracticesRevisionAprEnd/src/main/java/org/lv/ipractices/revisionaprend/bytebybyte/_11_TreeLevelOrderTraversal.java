package org.lv.ipractices.revisionaprend.bytebybyte;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _11_TreeLevelOrderTraversal {



    /*
     breadth first search
     */
    public static void levelOrderTraversal(BinarySearchTree.TreeNode<Integer,String> root){

        Deque<BinarySearchTree.TreeNode<Integer,String>> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            BinarySearchTree.TreeNode<Integer,String> node = queue.removeFirst();
            System.out.println(node.key);
            if(node.left!=null){
                queue.addLast(node.left);
            }
            if(node.right!=null){
                queue.addLast(node.right);
            }
        }

    }



    public static void main(String[] args){

        BinarySearchTree<Integer,String> bst = new BinarySearchTree();
        bst.put(11, "Something");
        bst.put(9, "Something");
        bst.put(7, "Something");
        bst.put(13, "Something");
        bst.put(15, "Something");
        bst.put(3, "Something");
        bst.put(5, "Something");
        bst.put(17, "Something");

        bst.preorder(bst.root);

        System.out.println("\n\n");
        levelOrderTraversal(bst.root);

    }
}
