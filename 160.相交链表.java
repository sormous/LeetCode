/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**感觉上题意不太明确！！
 * 本题主要为题意理解：理解为给出的两个链表中有些节点是共用的，也就是地址一样，找出其中的第一个节点
 * 此题中有两个链表，首先将其中一个链表B尾节点指向头节点，形成了B链表的环
 * 然后，从链表A头节点开始，利用快慢指针从头遍历，证明是否有环，若有则说明有共用节点
 * 最后将相遇的快慢指针中的一个指向A的头节点，再同时依次遍历，再次相遇的节点即为相交的第一个节点
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode last = headB;
        while(last.next != null){
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = headA;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }
}
// @lc code=end

