package com.wyh.java.sword;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * @author WangYingHao
 * @since 2019-08-28
 */
public class A12 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode offsetKNode = head;
        while (k > 0) {
            if (offsetKNode != null) {
                offsetKNode = offsetKNode.next;
                k--;
            } else {
                return null;
            }
        }
        while (offsetKNode != null) {
            offsetKNode = offsetKNode.next;
            head = head.next;
        }
        return head;
    }
}
