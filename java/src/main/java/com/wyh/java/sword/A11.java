package com.wyh.java.sword;

/**
 * 反转链表
 *
 * @author WangYingHao
 * @since 2019-08-28
 */
public class A11 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next; //用next来暂存下一个节点，防止链表断裂
            head.next = head; //下一个节点指向当前节点，实现反序
            pre = head; //前一个节点移动到当前节点
            head = next; //当前节点移动到下一个节点
        }
        return pre;
    }
}
