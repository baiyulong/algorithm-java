package org.example.day6;

import org.example.TreeNode;


/**
 * 2022-08-01
 * 二叉树遍历
 *
 * @author YULONG
 */
public class D61 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pre(head);
    }

    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void mid(TreeNode head) {
        if (head == null) {
            return;
        }
        mid(head.left);
        System.out.println(head.value);
        mid(head.right);
    }

    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }
}
