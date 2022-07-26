package org.example.day4;

import org.example.SingleNode;
import org.example.Utils;


/**
 * 2022-07-26
 * 两个链表相加
 *
 * @author YULONG
 */
public class D41 {

    public static void main(String[] args) {
        SingleNode head1 = new SingleNode(1);
        head1.next(2).next(3);
        SingleNode head2 = new SingleNode(4);
        head2.next(5).next(6).next(7);
        SingleNode f = f(head1, head2);
        Utils.printLinkedList(f);
    }

    public static SingleNode f(SingleNode head1, SingleNode head2) {
        int len1 = length(head1);
        int len2 = length(head2);
        // Get longer and shorter linked list
        // We will change the longer list as the final list.
        SingleNode l = len1 > len2 ? head1 : head2;
        SingleNode s = l.equals(head1) ? head2 : head1;
        SingleNode curl = l;
        SingleNode curs = s;
        SingleNode last = null;
        int carry = 0;
        int sum = 0;
        // 1. Traversal part of the two list that each node is not null
        while (curs != null) {
            sum = curl.value + curs.value + carry;
            curl.value = sum % 10;
            carry = sum / 10;
            last = curl;
            curl = curl.next;
            curs = curs.next;
        }
        // 2. Traversal part of the longer list
        while (curl != null) {
            sum = curl.value + carry;
            curl.value = sum % 10;
            carry = sum / 10;
            last = curl;
            curl = curl.next;
        }
        // 3. Last process
        if (carry != 0) {
            last.next = new SingleNode(carry);
        }
        return l;
    }

    private static int length(SingleNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
