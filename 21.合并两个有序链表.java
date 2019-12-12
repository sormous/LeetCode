/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    /**
     * 合并两个有序链表成一个新的有序链表
     * 
     * 使用root头节点进行辅助操作，创建一个头节点，在创建两个指针指向两个链表的头节点
     * 将较小的节点值连接到root后，同时这个指向这个较小值的指针移动到下一个节点，
     * 一直操作，直到其中一个链表为空，最后将剩下的节点连接到root链表后
     * 最后返回root的下一个节点，其就为新的链表头
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //创建一个root头节点，最后删除
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1 != null && l2 != null){
            //比较当前指针指向节点的值，较小的连接到root链表后
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        //将不为空的剩下的一个链表连接到root链表之后
        tail.next = (l1 != null? l1:l2);

        //最后返回root节点的下一个节点，即为第一个数据节点
        return head.next;
    }
}
// @lc code=end

