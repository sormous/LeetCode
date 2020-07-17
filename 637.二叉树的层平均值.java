import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>(); //利用队列对二叉树进行层次遍历
        int count = 0, l = 0; //count记录该层有多少个节点，l代表层数，根结点为0层
        long sum = 0; //记录每一层的和值，使用long，避免两个int之和越界
        List<Double> ans = new ArrayList<Double>();
        TreeNode flag = null; //作为每一层分层节点标志
        if(root == null) return ans;
        //初始在队列中放入根节点即0层标志
        q.offer(root); 
        q.offer(flag);
        //开始层次遍历
        while(!q.isEmpty()){
            TreeNode temp = q.poll(); //弹出队列第一个元素
            //不为空，则为正常节点，求和值及放入其子节点
            if(temp != null){
                sum += temp.val;
                count++;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            //为空，则为分层标志节点
            else{
                //计算该层的节点值平均值
                ans.add(l, (double)sum/count);
                //层数增加
                l++;
                //重置记录
                count = 0;
                sum = 0;
                //若队列中还有节点，则继续放入分层标志节点，增加判断，避免死循环
                if(!q.isEmpty()) q.offer(flag);
            }
        }
        return ans;
    }
}
// @lc code=end

