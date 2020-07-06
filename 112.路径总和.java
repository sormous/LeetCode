/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 看作一个递归，自顶向下，每次判断减去当前节点值
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false; //首先判断该二叉树是否为空
        // 若根节点下再无子节点，则直接判断是否等于所给值
        if(root.left == null && root.right == null){
            return sum - root.val == 0;
        }
        // 存在子节点则递归判断，左子树或右子树中是否有满足路径和要求的路径
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
// @lc code=end

