package org.example.day7;

import org.example.TreeNode;

import java.util.Stack;


/**
 * 2022-08-02
 * 二叉树非递归遍历
 *
 * @author YULONG
 */
public class D71 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pos(head);
    }

    public static void pre(TreeNode head) {
        System.out.println("======================== Pre reverse ======================");
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.value);
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void mid(TreeNode head) {
        if (head == null) {
            return;
        }
    }

    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.right != null) {
                stack1.push(head.right);
            }
            if (head.left != null) {
                stack1.push(head.left);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().value);
        }
    }

    public static void pos1(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode h = null;
        TreeNode c = head;

    }
}
