/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * 利用分治的思想，将整体链表，逐步分为两个链表进行合并
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int l, int r){
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }

        int mid = l+(r-l)/2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid+1, r));
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1 == null ? l2:l1;
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1:l2;
        return head.next;
    }
}
// @lc code=end

