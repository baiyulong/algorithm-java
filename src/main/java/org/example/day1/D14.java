package org.example.day1;

import static org.example.Utils.*;

/**
 * 2022-07-09
 * Insert sort
 *
 * @author YULONG
 */
public class D14 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 50);
        print(arr);
        f(arr);
        print(arr);
    }

    public static void f(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 0 ~ 1
        // 0 ~ 2
        // 0 ~ 3
        // 0 ~ n - 1
        int n = arr.length;
        for (int end = 0; end < n; end++) {
            int cur = end;
            while (cur - 1 >= 0 && arr[cur - 1] > arr[cur]) {
                swap(arr, cur - 1, cur);
                cur--;
            }
        }

    }
}
