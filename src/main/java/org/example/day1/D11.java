package org.example.day1;

/**
 * 2022-07-09
 *
 * @author YULONG
 */
public class D11 {

    public static void main(String[] args) {
        // 1! + 2! + 3! + 4! + N!
        System.out.println(f(10));
    }

    public static long f(int n) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }
}
