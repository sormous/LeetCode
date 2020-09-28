/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
 * 因为最长直径不一定经过根节点，所以得判断所有节点
 * 利用dfs判断所有节点
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root.left == null && root.right == null){
            return 0;
        }
        
        int leftSize = root.left == null ? 0:dfs(root.left)+1;
        int rightSize = root.right == null ? 0:dfs(root.right)+1;
        max = Math.max(max, leftSize+rightSize);
        return Math.max(leftSize, rightSize);
    }
}
// @lc code=end

