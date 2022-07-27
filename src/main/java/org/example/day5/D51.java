package org.example.day5;

import org.example.SingleNode;
import org.example.Utils;


/**
 * 2022-07-27
 * 两个有序链表合并
 *
 * @author YULONG
 */
public class D51 {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        head1.next(2).next(5);
        SingleNode head2 = new SingleNode(3);
        head2.next(4).next(7).next(8);
        SingleNode f = f(head1, head2);
        Utils.printLinkedList(f);
    }

    public static SingleNode f(SingleNode head1, SingleNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        SingleNode head = head1.value < head2.value ? head1 : head2;
        SingleNode cur1 = head.next;
        SingleNode cur2 = head == head1 ? head2 : head1;
        SingleNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
