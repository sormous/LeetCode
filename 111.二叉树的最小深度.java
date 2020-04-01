
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
class Solution {
    /**
     * 求最小深度时将Math.max换成Math.min即可，
     * 但要注意如果根节点的左或右子树为空的话是构不成子树的。
     * 而最小深度是要求从根节点到子树的。
     * 当左或右子树为空时，不符合要求。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right != null){
            return 1+minDepth(root.right);
        }

        if(root.left != null && root.right == null){
            return 1+minDepth(root.left);
        }

        return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }
}
// @lc code=end

