package org.example.day3;

import org.example.Node;
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
        Node head = new Node(1);
        head.next(2).next(3).next(4).next(5).next(6).next(7).next(8);
        Utils.printLinkedList(head);
        head = f(head, 3);
        Utils.printLinkedList(head);
    }

    public static Node f(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pt = null;
        Node ih = head;
        Node t = head;
        head = getEnd(head, k);
        while (ih != null) {
            // 2. Find a new group end
            t = getEnd(ih, k);
            if (t == null) {
                break;
            }
            // 1. Cut down pre group
            if (pt != null) {
                pt.next = null;
            }
            // 3. Mark next group
            Node nh = t.next;
            // 4. Cut down t and nh
            t.next = null;
            // 5. Reverse new group
            reverse(ih);
            // 6. Link reversed group to list
            ih.next = nh;
            // 9. Reset pt.next
            if (pt != null) {
                pt.next = t;
            }
            // 7. Reset pt
            pt = ih;
            // 8. Reset ih
            ih = nh;
        }
        return head;
    }

    private static Node getEnd(Node head, int k) {
        Node h = head;
        for (int i = 0; i < k - 1; i++) {
            h = h.next;
            if (h == null) {
                h = null;
                break;
            }
        }
        return h;
    }

    private static Node reverse(Node head) {
        Node cur = null;
        Node tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        return cur;
    }
}
