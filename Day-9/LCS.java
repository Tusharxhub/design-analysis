//! wap in java to perform Longest Common Subsequence

public class LCS {
    static int lcs(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB", Y = "GXTXAYB";
        System.out.println("Length of LCS: " + lcs(X, Y));
    }
}




// ? Time Complexity: O(m * n)
// ? Space Complexity: O(m * n)