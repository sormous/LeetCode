import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
 * 利用深度优先遍历算法
 */
class Solution {
    //分别初始化两个LinkedList来分别存储返回答案和每一条路径
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode root, int sum){
        if(root == null) return ;
        //在当前路径最后添加当前节点值
        path.offerLast(root.val);
        //更新sum值
        sum -= root.val;
        //当找到叶子节点且sum值为0后，则找到目标路径
        if(root.left == null && root.right == null && sum == 0){
            //添加新初始化的LinkedList路径
            res.add(new LinkedList<>(path));
        }
        //然后分别对节点的左右子节点进行递归
        dfs(root.left, sum);
        dfs(root.right, sum);
        //递归返回之后移除路径最后一个元素
        path.pollLast();
    }
}
// @lc code=end

