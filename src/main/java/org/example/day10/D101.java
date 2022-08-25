package org.example.day10;

import org.example.SingleNode;

import java.util.Stack;


/**
 * 2022-08-25
 * 给定一个值，将小于该值的节点放在左边，大于该值的节点放到右边
 *
 * @author YULONG
 */
public class D101 {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(3);
        head.next(2).next(3).next(5).next(6).next(1).next(3).next(0);
        SingleNode nHead = f(head, 3);
        System.out.println(nHead.value);
    }

    /**
     * 奇数时返回中点，偶数时返回前中点
     *
     * @param head 1
     * @return org.example.SingleNode
     * @author Bai Yulong
     * @since 0.1.0
     */
    public static SingleNode f(SingleNode head, int n) {
        if (head == null) {
            return head;
        }
        SingleNode sh = null, st = null, eh = null, et = null, bh = null, bt = null, next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value > n) {
                if (bh == null) {
                    bh = head;
                    bt = head;
                    bh.next = bt;
                } else {
                    bt.next = head;
                    bt = bt.next;
                }
            } else if (head.value < n) {
                if (sh == null) {
                    sh = head;
                    st = head;
                    sh.next = st;
                } else {
                    st.next = head;
                    st = st.next;
                }
            } else {
                if (eh == null) {
                    eh = head;
                    et = head;
                    eh.next = et;
                } else {
                    et.next = head;
                    et = et.next;
                }
            }
            head = next;
        }
        head = sh;
        if (st != null) {
            st.next = eh;
        } else {
            head = eh;
        }
        if (et != null) {
            et.next = bh;
        } else {
            head = bh;
        }
        return head;
    }
}
