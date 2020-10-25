/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    //归并排序
    private ListNode mergeSort(ListNode head) {
        //如果为空或者只有一个节点，无需排序，直接返回
        if(head == null || head.next == null) return head;
        //利用快慢指针找中位节点
        ListNode slow = head, fast = head.next.next, l, r;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //对右边节点进行排序
        r = mergeSort(slow.next);
        //链表判断结束的标志，末尾置空
        slow.next = null;
        //对左边节点进行归并排序
        l = mergeSort(head);
        return mergeList(l, r);
    }

    //合并链表
    private ListNode mergeList(ListNode l, ListNode r){
        //临时头节点
        ListNode tempHead = new ListNode(0);
        ListNode  p = tempHead;
        while(l != null && r != null){
            if(l.val <= r.val){
                p.next = l;
                l = l.next;
            }else{
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r:l;
        return tempHead.next;
    }
}

// @lc code=end

