import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
     * 利用层次遍历，每遍历一层则记录一个
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //或者利用递归思想，最大深度为左右子树中深度大的加1
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;

        //首先判断空树，则返回深度0
        // if(root == null) return 0;

        // int depth = 0;
        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()){
        //     depth++;
        //     //利用l记录当前层次的节点个数，遍历完当前层次的节点，接着到达下一层
        //     int l = q.size();
        //     while(l>0){
        //         TreeNode temp = q.poll();
        //         if(temp.left != null){
        //             q.add(temp.left);
        //         }
        //         if(temp.right != null){
        //             q.add(temp.right);
        //         }
        //         l--;
        //     }
        // }
        // return depth;
    }
}
// @lc code=end

