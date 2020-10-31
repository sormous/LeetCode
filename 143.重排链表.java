/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
 * 1.快慢指针找到中点 
 * 2.拆成两个链表 
 * 3.遍历两个链表，后面的塞到前面的“缝隙里”
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        //利用快慢指针找到中间节点
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //将后半部分的节点反转
        ListNode last = slow.next;
        slow.next = null;
        last = reverse(last);

        //将后端节点插入到前端节点的中间
        //新建node-cur记录链表当前的节点
        ListNode cur = head;
        while(cur != null && last != null){
            //要插入的节点为last，新建一个node记录
            ListNode curSecond = last;
            //last节点变为下一个
            last = last.next;
            //新建node记录原cur节点的next
            ListNode curNext = cur.next;
            //插入节点的next为原cur节点的next节点
            curSecond.next = cur.next;
            //原cur节点的next变为插入的节点
            cur.next = curSecond;
            //原cur节点变为原cur的next
            cur = curNext;
        }
    }

    //将链表节点反转
    private ListNode reverse(ListNode head){
        ListNode n1 = null;
        ListNode n2 = head;
        ListNode n3 = n2;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        return n1;
    }
}
// @lc code=end

