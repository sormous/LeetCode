import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
class Solution {
    Map<TreeNode, Integer> mem = new HashMap<>();

    public int rob(TreeNode root) {
        //首先处理边界case，root为空则直接返回0
        if(root == null){
            return 0;
        }
        //
        if(mem.containsKey(root)){
            return mem.get(root);
        }
        //分别求出抢当前节点和不抢当前节点，可获得的最高金额
        //抢当前节点，那么后续能抢的则是左节点和右节点的子节点
        int do_it = root.val + 
        (root.left == null ? 0:rob(root.left.left)+rob(root.left.right)) +
        (root.right == null ? 0:rob(root.right.left)+rob(root.right.right));
        //若未抢当前节点，那么后续可以抢当前节点的左右节点
        int not_do = (rob(root.left)+rob(root.right));

        int res = Math.max(do_it, not_do);
        mem.put(root, res);
        return res;

    }
}
// @lc code=end

