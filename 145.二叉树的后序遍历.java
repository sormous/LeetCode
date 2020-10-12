import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
 * 后续遍历顺序为：左->右->根,
 * 后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
 * 如果是从右边再返回根结点，应该回到上层。
 * 主要就是判断出来的是不是右子树，是的话就可以把根节点=加入到list
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = null; //用来记录上一节点
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == p){
                res.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
        return res;
    }
}
// @lc code=end

