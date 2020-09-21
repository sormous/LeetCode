/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
        if(head == null) return head;
        //用flag表示当前节点值是否为重复值
        boolean flag = false;
        //新建一个链表作为存储链表
        ListNode l = new ListNode(0);
        //s节点表示新链表保存到的位置
        ListNode s = l;
        //temp表示将要作比较的节点
        ListNode temp = head;
        while(temp != null){
            //初始flag
            flag = false;
            //若当前节点的下一个节点非空且当前节点值与下一个节点值相等
            //flag置true，且temp节点后移
            while(temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
                flag = true;
            }
            if(flag){
                //将temp节点置为下一个非重复值节点
                temp = temp.next;
                continue;
            }
            //将非重复值节点加入新链表中
            s.next = temp;
            temp = temp.next;
            s = s.next;
            //新链表后续置空
            s.next = null;
        }
        
        return l.next;
    }
}
// @lc code=end

