import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(start > end){
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTree(start, i-1);
            List<TreeNode> subRightTree = generateTree(i+1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
// @lc code=end

       