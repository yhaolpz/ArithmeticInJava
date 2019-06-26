package com.wyh.java.sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author WangYingHao
 * @since 2019-06-23
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class A6 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        } else if (listNode.next == null) {
            list.add(listNode.val);
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            stack.push(listNode.val);
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
