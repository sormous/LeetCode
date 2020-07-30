/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        //首先判断头指针的值
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return head;
        //双指针，cur表示当前节点,temp表示将要作比较的下一个节点
        ListNode cur = head;
        ListNode temp = head.next;
        while(temp != null){
            //若节点值等于给定元素值，则移除该节点
            //cur不变，cur.next变为temp.next，temp也变为temp.next
            if(temp.val == val){
                cur.next = temp.next;
                temp = cur.next;
            }else{
                //若节点值不等于给定元素值，则同时向后移一个节点
                cur = cur.next;
                temp = cur.next;
            }
        }
        return head;
    }
}
// @lc code=end

