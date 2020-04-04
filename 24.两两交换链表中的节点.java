/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //先判断特殊情况，空链表和只有一个节点的链表，直接返回原链表
        if(head == null || head.next == null) return head;

        ListNode root = new ListNode(0);
        ListNode tail = root;
        ListNode temp = head;
        while(head != null && head.next != null){
            //将第2个节点交换位置连接至头节点上
            temp = head.next;
            tail.next = temp;
            tail = tail.next;
            //临时记录第3个节点
            temp = temp.next;
            //将第1个节点交换位置连接至之后
            tail.next = head;
            tail = tail.next;
            head.next = temp;
            //将当前头指针指向第3个节点
            head = temp;
        }
        return root.next;
    }
}
// @lc code=end

