//! wap in java to perform Longest Common Subsequence

import java.util.Scanner;

public class LCS {
    public static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String X = sc.nextLine();
        System.out.print("Enter second string: ");
        String Y = sc.nextLine();
        sc.close();

        int length = lcs(X, Y);
        System.out.println("Length of Longest Common Subsequence: " + length);
    }
}
