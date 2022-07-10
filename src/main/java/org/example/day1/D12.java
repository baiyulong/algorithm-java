package org.example.day1;

import static org.example.Utils.*;

/**
 * 2022-07-09
 * Select sort
 *
 * @author YULONG
 */
public class D12 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 50);
        print(arr);
        f(arr);
        print(arr);
    }

    public static void f(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }
}
