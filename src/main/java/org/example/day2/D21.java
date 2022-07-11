package org.example.day2;

import org.example.day1.D12;

import static org.example.Utils.print;
import static org.example.Utils.randomArray;

/**
 * 2022-07-10
 * 二分查找
 *
 * @author YULONG
 */
public class D21 {

    public static void main(String[] args) {
        int[] arr = randomArray(10, 10);
        D12.f(arr);
        print(arr);
        System.out.println(f(arr, 5));
    }

    public static int f(int[] arr, int target) {
        int ans = -1;
        if (arr == null) {
            return ans;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] < target) {
                l = mid + 1;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
