package org.lv.ipractices.revisionaprend.bytebybyte;

public class _6_BinarySearchTree {


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

        bst.inorder(bst.root);

        System.out.println("Bst naive :"+bst.isBst(bst.root));
        System.out.println("Bst revised :"+bst.isBst(bst.root));

        /*
        3,5,7,9,11,13,15,17
         */
      //
    }

}
