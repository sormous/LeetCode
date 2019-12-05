/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = new ListNode(0);
        ListNode r = root;
        root.next = l1;

        int carry = 0;
        int sum;
        while(p1 != null && p2 != null){
            sum = p1.val + p2.val + carry;
            p1.val = sum%10;
            carry = sum/10;

            r.next = p1;
            r = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null){
            r.next = p2;
        }else{
            r.next = p1;
        }
        if(carry == 1){
            while(r.next != null && carry != 0){
                sum = r.next.val + carry;
                r.next.val = sum%10;
                carry = sum / 10;
                r = r.next;
            }
            if(carry == 1){
                r.next = new ListNode(1);
            }
        }
        return root.next;
    }
}
// @lc code=end

