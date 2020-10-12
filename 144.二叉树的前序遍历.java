import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
 * 前序遍历顺序为：根->左->右
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        //使用栈来存储节点，方便前序迭代遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //利用迭代的方式进行遍历
        while(!stack.empty()){
            //根节点出栈
            TreeNode cur = stack.pop();
            res.add(cur.val);
            //先将右子树存入栈中，后出栈
            if(cur.right != null){
                stack.add(cur.right);
            }
            //再将左子树存入栈中
            if(cur.left != null){
                stack.add(cur.left);
            }
        }
        return res;
    }
}
// @lc code=end

