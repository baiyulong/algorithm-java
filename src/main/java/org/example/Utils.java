package org.example;

/**
 * @author YULONG
 */
public final class Utils {

    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public static void printLinkedList(Node head) {
        System.out.print(head.value + " -> ");
        while (head.next != null) {
            System.out.print(head.next.value + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static int[] randomArray(int maxLength, int max) {
        int[] arr = new int[maxLength];
        for (int i = 0; i < maxLength - 1; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Node loopHead(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        if (head.next.next == head) {
            return head;
        }
        Node f = head.next.next;
        Node s = head.next;
        while (f != s) {
            f = f.next.next;
            s = s.next;
        }
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }
}
