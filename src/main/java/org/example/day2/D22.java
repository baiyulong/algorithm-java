package org.example.day2;

import org.example.day1.D12;

import static org.example.Utils.print;
import static org.example.Utils.randomArray;

/**
 * 2022-07-10
 * 二分查找，寻找最左的位置
 *
 * @author YULONG
 */
public class D22 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 10);
//        int[] arr = {0, 1, 1, 2, 3, 5, 5, 8, 9, 9};
        D12.f(arr);
        print(arr);
        System.out.println(f(arr, 5));
    }

    public static int f(int[] arr, int target) {
        if (arr == null) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int t = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= target) {
                t = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return arr[t] == target ? t : -1;
    }
}
