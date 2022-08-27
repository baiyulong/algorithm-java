package org.example.day11;

import org.example.Node;
import org.example.Utils;


/**
 * 2022-08-27
 * 求两个环形链表相交部分任意一个开头节点
 *
 * @author YULONG
 */
public class D112 {

    public static void main(String[] args) {
        Node head1 = new Node(11);
        Node n4 = head1.next(12).next(13).next(4);
        Node n5 = n4.next(5);

        Node head2 = new Node(21);
        Node n23 = head2.next(22).next(23);
        n23.next = n5;

        Node n8 = n5.next(6).next(7).next(8);
        n8.next = n4;

        Node nHead = f(head1, head2);
        System.out.println(nHead.value);
    }

    /**
     * Clone with hash map
     *
     * @param head1 1
     * @param head2 2
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static Node f(Node head1, Node head2) {
        Node lpHead1 = Utils.loopHead(head1);
        Node lpHead2 = Utils.loopHead(head2);
        return lpHead1 == null && lpHead2 == null
                ? noLoop(head1, head2)
                : bothLoop(lpHead1, lpHead2);
    }

    private static Node noLoop(Node head1, Node head2) {
        // 计算两个链表的长度，取得链表长度差值
        int n = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            n--;
            cur2 = cur2.next;
        }
        // 确定长短链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        // 保持长链表和短链表剩余节点个数相同
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        // 如果两个节点相等，说明是第一个相交的节点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static Node bothLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        if (head1 == head2) {
            return head1;
        }
        while (head1 != head2) {
            head1 = head1.next;
            if (head1 == head2) {
                return head2;
            }
        }
        return null;
    }
}
