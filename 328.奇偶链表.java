/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        //首先判空
        if(head == null) return head;
        //新申明三个节点，a表示奇数节点当前位置，b表示偶数节点当前位置
        //head2表示偶数节点的头节点
        ListNode a = head, b = head.next, head2 = head.next;
        //然后对链表进行遍历，满足奇数和偶数当前位置都不为空，且偶数位置的下一个位置也不空
        while(a != null && b != null && b.next != null){
            //然后奇数连奇数位置，偶数连偶数位置
            a.next = b.next;
            a = a.next;
            b.next = a.next;
            b = b.next;

        }
        a.next = head2;
        return head;
    }
}
// @lc code=end

