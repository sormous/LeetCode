/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        // if(head == null){
        //     return head;
        // }
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(head != null){
            if(head.val < x){
                //新建节点避免链表循环
                t1.next = new ListNode(head.val);

                //或者每次新增节点时令后续为空
                // t1.next = head;
                //提前变化head节点，若在if外变化则会因为t1.next=null使得后续都变为空
                // head = head.next;
                t1 = t1.next;
                // t1.next = null;
            }
            else{
                t2.next = new ListNode(head.val);

                // t2.next = head;
                // head = head.next;
                t2 = t2.next;
                // t2.next = null;
            }

            head = head.next;
        }
        t1.next = l2.next;
        return l1.next;
    }
}
// @lc code=end

