import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
        //利用栈来存储链表上的值，来实现倒序，使得对应位置相加
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode ans = null;
        //考虑进位
        int carry = 0;
        //当栈不为空，且进位也不等于0时
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int a = stack1.isEmpty()? 0:stack1.pop();
            int b = stack2.isEmpty()? 0:stack2.pop();
            int cur = a+b+carry;
            carry = cur/10;
            cur = cur%10;
            //新申明一个节点，利用头插法进行插入
            ListNode temp = new ListNode(cur);
            temp.next = ans;
            ans = temp;
        }
        return ans;
    }
}
// @lc code=end

