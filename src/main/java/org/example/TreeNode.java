package org.example;

import java.util.Objects;

/**
 * @author Bai Yulong<baiyl3@lenovo.com>
 * @version 0.1.0
 * @since 0.1.0
 **/
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
