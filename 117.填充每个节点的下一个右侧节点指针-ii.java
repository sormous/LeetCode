import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
 * 方法1：利用层序遍历，遍历每一层节点，然后将每一层节点进行连接
 * 方法2：可以在上一层为下一层建立next指针，然后利用双指针分别记录该层的开始节点和遍历过程中的上一个节点
 */
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if(i < size-1){
                    temp.next = q.peek();
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return root;
    }
}
// @lc code=end

