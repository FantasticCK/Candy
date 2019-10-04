package com.CK;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }
}

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        int res = 0;
        if (n == 0)
            return 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                candy[i] = 1;
                continue;
            }

            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                res += candy[i];
                continue;
            }

            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
            res += candy[i];
        }

        return res;
    }
}