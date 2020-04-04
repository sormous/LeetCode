/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        //先判断特殊情况，当链表为空时直接返回
        if(head == null || head.next == null){
            return head;
        }
        //利用两个节点依次进行比较
        ListNode tail = head;
        ListNode temp = head.next;
        while(temp != null){
            if(tail.val != temp.val){
                tail.next = temp; 
                tail = tail.next;
            }
            temp = temp.next;
        }
        //若重复节点在最后时，需要将后续的节点断开
        tail.next = null;
        return head;
    }
}
// @lc code=end

