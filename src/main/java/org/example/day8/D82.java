package org.example.day8;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 2022-08-07
 * 二叉树层序序列化
 *
 * @author YULONG
 */
public class D82 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.right.left = new TreeNode(8);
        head.right.left = new TreeNode(6);
        head.right.left.right = new TreeNode(9);
        head.right.right = new TreeNode(7);
        System.out.println(serialize(head));
    }

    public static List<String> serialize(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<String> ans = new ArrayList<>(16);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            ans.add(String.valueOf(head.value));
            if (head.left != null) {
                ans.add(String.valueOf(head.left.value));
                queue.add(head.left);
            } else {
                ans.add(null);
            }
            if (head.right != null) {
                ans.add(String.valueOf(head.right.value));
                queue.add(head.right);
            } else {
                ans.add(null);
            }
        }
        return ans;
    }

    private static TreeNode deserialize(Queue<String> list) {
        if (list == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = buildNode(list.poll());
        queue.add(head);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = buildNode(list.poll());
            node.right = buildNode(list.poll());
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return head;
    }

    private static TreeNode buildNode(String value) {
        if (value == null) {
            return null;
        }
        return new TreeNode(Integer.parseInt(value));
    }
}
