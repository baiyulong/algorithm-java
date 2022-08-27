package org.example.day9;

import org.example.Node;

import java.util.Stack;


/**
 * 2022-08-24
 * 判断链表是否是回文结构
 *
 * @author YULONG
 */
public class D91 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next(2).next(3).next(2).next(1);
        boolean mid = f(head);
        System.out.println(mid);
    }

    /**
     * 不使用新空间
     *
     * @param head 1
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static boolean f(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return false;
        }
        // 之后说明链表至少有 3 个节点
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node cur = null;
        Node tmp;
        Node rHead = slow.next;

        while (rHead != null) {
            tmp = rHead.next;
            rHead.next = cur;
            cur = rHead;
            rHead = tmp;
        }

        boolean rs = false;
        Node l = head;
        Node r = cur;
        while (l != null && r != null) {
            rs = r.equals(l);
            if (!rs) {
                break;
            }
            l = l.next;
            r = r.next;
        }
        rHead = cur;
        cur = null;
        while (rHead != null) {
            tmp = rHead.next;
            rHead.next = cur;
            cur = rHead;
            rHead = tmp;
        }
        return rs;
    }

    public static boolean f1(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return false;
        }
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        boolean rs = false;
        while (!stack.isEmpty()) {
            node = stack.pop();
            rs = node.equals(head);
            if (rs) {
                break;
            }
            head = head.next;
        }
        return rs;
    }
}
