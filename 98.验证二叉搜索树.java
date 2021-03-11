import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
//利用中序遍历，返回的数字为有序的，该方法中利用stack来实现中序遍历
class Solution {
    //需要用double类型来记录初始最小值，用int可能范围值不够
    private double pre = -Double.MAX_VALUE;
    Stack<TreeNode> stack = new Stack<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return mid(root);
    }

    private boolean mid(TreeNode root){
        while(!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= pre){
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
// @lc code=end

