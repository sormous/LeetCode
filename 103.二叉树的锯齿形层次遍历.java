import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        //维护一个变量记录当前是从左至右还是从右至左
        boolean isOrderLeft = true;

        while(!nodeQueue.isEmpty()){
            //重置列表，记录每一行节点数据
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                //判断当前遍历顺序
                if(isOrderLeft){
                    levelList.offerLast(curNode.val);
                }else{
                    levelList.offerFirst(curNode.val);
                }
                //将下一行的非空节点放入队列中
                if(curNode.left != null){
                    nodeQueue.offer(curNode.left);
                }
                if(curNode.right != null){
                    nodeQueue.offer(curNode.right);
                }
            }
            //每遍历一行节点，则添加进答案列表中
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
// @lc code=end

