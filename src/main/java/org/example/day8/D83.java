package org.example.day8;

import org.example.Node;


/**
 * 2022-08-07
 * 链表求中点，奇数个数链表求中点，偶数个数链表求前中点
 *
 * @author YULONG
 */
public class D83 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next(2).next(3).next(4).next(5).next(6).next(7);
        Node mid = f(head);
        System.out.println(mid.value);
    }

    /**
     * 奇数时返回中点，偶数时返回前中点
     *
     * @param head 1
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static Node f(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 奇数时返回中点，偶数时返回后中点
     *
     * @param head 1
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static Node f1(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
