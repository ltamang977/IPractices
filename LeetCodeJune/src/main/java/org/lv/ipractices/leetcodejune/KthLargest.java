package org.lv.ipractices.leetcodejune;


import java.util.Stack;

class KthLargest {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    TreeNode root;
    int k;
    public KthLargest(int k, int[] nums) {
        if(nums==null)
            throw new IllegalArgumentException();

        this.root = null;
        this.k = k;

        for(int i=0; i<nums.length; i++){
            // root = addNode(root, nums[i]);
            this.root = insertIntoBST( root,  nums[i]);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = new TreeNode(val);

        if(root==null)
            return node;

        TreeNode prev = null;
        TreeNode curr = root;

        while(curr!=null){
            prev=curr;
            if(val<=curr.val){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        if(val<=prev.val){
            prev.left = node;
        }else{
            prev.right = node;
        }

        return root;
    }

    private TreeNode addNode(TreeNode root, int val){

        if(root==null){
            return new TreeNode(val);
        }

        if(val<=root.val){
            root.left = addNode(root.left, val);

        }else{
            root.right = addNode(root.right, val);
        }

        return root;

    }

    public int add(int val) {

        root =  insertIntoBST(root,  val);

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(node!=null){
            stack.push(node);
            node=node.right;
        }

        int i = 0;
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            if(k==++i){
                return n.val;
            }

            if(n.left!=null){
                n = n.left;
                while(n!=null){
                    stack.push(n);
                    n = n.right;
                }
            }
        }

        return -1;

    }


    public static void main(String[] args){


        int[] nums = {4,5,8,2};
        int k = 3;

        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(3);
        System.out.println(param_1);

        int param_2 = obj.add(5);
        System.out.println(param_2);

        int param_3 = obj.add(10);
        System.out.println(param_3);

        int param_4 = obj.add(9);
        System.out.println(param_4);

        int param_5 = obj.add(4);
        System.out.println(param_5);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
