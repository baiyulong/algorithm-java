package org.example.day7;

import org.example.TreeNode;

import java.util.*;


/**
 * 2022-08-06
 * 二叉树层序遍历
 *
 * @author YULONG
 */
public class D72 {

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
        System.out.println(maxLevel2(head));
    }

    public static void level(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    /**
     * 求最宽层的元素个数，使用 Map
     * @param head
     * @return int
     */
    public static int maxLevel(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int maxNodes = 0;
        int curLevel = 0;
        int curNodeLevel = 0;
        int count = 1;
        TreeNode cur = head;
        Map<TreeNode, Integer> levels = new HashMap<>(16);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        levels.put(head, 1);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curNodeLevel = levels.get(cur);
            if (cur.left != null) {
                levels.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levels.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                count++;
            } else {
                maxNodes = Math.max(maxNodes, count);
                curLevel++;
                count = 1;
            }
        }
        return Math.max(maxNodes, count);
    }

    /**
     * 求最宽层的元素数量，只用一个队列
     * @param head
     * @return int
     */
    public static int maxLevel2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int max = 0;
        int nodes = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode cur = head;
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            nodes++;
            if (cur == curEnd) {
                max = Math.max(max, nodes);
                nodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
}
