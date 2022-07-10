package org.example.day1;

import static org.example.Utils.*;

/**
 * 2022-07-09
 * Bubble sort
 *
 * @author YULONG
 */
public class D13 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 50);
        print(arr);
        f(arr);
        print(arr);
    }

    public static void f(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }
}
