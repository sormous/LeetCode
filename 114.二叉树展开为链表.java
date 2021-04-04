/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * 利用后序遍历的思想，先将左右子树展开成链表，再对根节点进行操作
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }

        flatten(root.left);
        flatten(root.right);

        //记录当前递归根节点的已经展开的左右子树
        TreeNode l = root.left;
        TreeNode r = root.right;
        //然后将当前的左子树放到右子节点上，左子树置空
        root.left = null;
        root.right = l;
        //然后遍历找到底部，将右子树连接上
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = r;
    }
}
// @lc code=end

