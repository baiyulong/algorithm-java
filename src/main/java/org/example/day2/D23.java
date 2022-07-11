package org.example.day2;

import static org.example.Utils.print;
import static org.example.Utils.randomArray;

/**
 * 2022-07-10
 * 二分查找，局部最小
 *
 * @author YULONG
 */
public class D23 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 10);
//        int[] arr = {8, 7, 1, 5, 6, 7, 3, 6, 0, 9};
        print(arr);
        System.out.println(f(arr));
    }

    public static int f(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1;
                continue;
            }
            if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
