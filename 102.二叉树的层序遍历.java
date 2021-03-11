import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    private List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    //设置间隔来在对类中分层
    //private TreeNode interval = new TreeNode(0);
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        q.add(root);
        //q.add(interval);
        bfs(res, q);
        return res;
    }
    
    //使用记录当前层次的方法来进行层次遍历
    private void bfs(List<List<Integer>> res, Queue<TreeNode> q){
        while(!q.isEmpty()){
            int curLevel = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < curLevel; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            res.add(level);
        }
    }

    //利用间隔的方式来确定层次，在本题中可能不太适用，因为数组中的数值为int类型
    // private void bfs(List<List<Integer>> res, Queue<TreeNode> q){
    //     List<Integer> l = new ArrayList<>();
    //     while(!q.isEmpty()){
    //         TreeNode temp = q.poll();
    //         if(temp.val == 0){
    //             res.add(l);
    //             if(q.size() == 0) break;
    //             l = new ArrayList<>();
    //             q.add(interval);
    //             continue;
    //         }
    //         l.add(temp.val);
    //         if(temp.left != null) q.add(temp.left);
    //         if(temp.right != null) q.add(temp.right);
    //     }
    // }
}
// @lc code=end

