package org.example.day3;

import org.example.SingleNode;
import org.example.Utils;

/**
 * 2022-07-11
 * K 个节点组内逆序调整
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
 * 3 -> 2 -> 1 -> 6 -> 4 -> 5 -> 7 -> 8
 *
 * @author YULONG
 */
public class D33 {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next(2).next(3).next(4).next(5).next(6).next(7).next(8);
        Utils.printLinkedList(head);
        head = f(head, 3);
        Utils.printLinkedList(head);
    }

    public static SingleNode f(SingleNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        SingleNode preTail;
        SingleNode s = head;
        SingleNode e = getEnd(s, k);
        if (e == null) {
            return head;
        }
        SingleNode t = e.next;
        e.next = null;
        e = s;
        s = reverse(s);
        head = s;
        preTail = e;
        s = t;
        preTail.next = s;
        e = getEnd(s, k);
        while (e != null) {
            t = e.next;
            e.next = null;
            e = s;
            s = reverse(s);
            preTail = e;
            preTail.next = s;
            s = t;
            e = getEnd(s, k);
        }
        return head;
    }

    private static SingleNode getEnd(SingleNode head, int k) {
        SingleNode h = head;
        for (int i = 0; i < k - 1; i++) {
            h = h.next;
            if (h == null) {
                h = null;
                break;
            }
        }
        return h;
    }

    private static SingleNode reverse(SingleNode head) {
        SingleNode cur = null;
        SingleNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}
