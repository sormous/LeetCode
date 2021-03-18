/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
 * 也可以用层序遍历的方法，对每一层的节点进行连接
 */
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node leftmost = root;
        while(leftmost.left != null){
            //遍历该层的节点链表，从最左节点开始
            Node head = leftmost;
            while(head != null){
                //第一种连接情况，同父节点直接左右相连
                head.left.next = head.right;

                //第二种连接情况，不同父节点，则
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            //因为是完美二叉树，所以每一层的最左节点一定是上一层最左节点的左节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
// @lc code=end

