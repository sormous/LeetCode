/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
/**
 * 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
 * 当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
 * 当前结点仍为2， 前驱结点依然是1，重复上一步操作
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //记录初始节点及最开始的pre节点
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode pre = dummy;
        //找需要交换位置的pre节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        //从m位置开始，循环交换至n位置
        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
// @lc code=end

