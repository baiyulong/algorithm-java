package org.example.day8;

import org.example.TreeNode;

import java.util.*;


/**
 * 2022-08-07
 * 二叉树先序序列化
 *
 * @author YULONG
 */
public class D81 {

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
        System.out.println(preSerialize(head));
    }

    public static List<String> preSerialize(TreeNode head) {
        if (head == null) {
            return null;
        }
        List<String> ans = new ArrayList<>(16);
        serialize(head, ans);
        return ans;
    }

    public static void serialize(TreeNode node, List<String> ans) {
        if (node != null) {
            ans.add(String.valueOf(node.value));
            serialize(node.left, ans);
            serialize(node.right, ans);
        } else {
            ans.add(null);
        }
    }

    /**
     * [1, 2, 4, null, null, 5, 8, null, null, null, 3, 6, null, 9, null, null, 7, null, null]
     * @param java.util.Queue
     * @return org.example.TreeNode
     */
    public static TreeNode preDeserialize(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(value));
        head.left = deserialize(queue);
        head.right = deserialize(queue);
        return head;
    }
}
