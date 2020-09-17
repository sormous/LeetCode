/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        //首先判空
        if(head == null) return head;
        int count = 1;
        ListNode temp = head;
        //对链表元素计数，并找到最后一个链表元素
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        //用k对count求余，避免多余的链表移动
        k = k % count;
        if(count == 1 || k == 0) return head;
        ListNode tail = head;
        //找到移动后的尾元素
        while(--count > k){
            tail = tail.next;
        }
        //进行移动
        ListNode newHead = tail.next;
        tail.next = null;
        temp.next = head;
        return newHead;
    }
}
// @lc code=end

