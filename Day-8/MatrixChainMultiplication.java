//! wap in java to perform Matrix chain multiplication



class MatrixChainMultiplication {
    static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] matrices = {1, 2, 3, 4};
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(matrices, matrices.length));
    }
}




// ? To perform enter the following command:
// ? javac MatrixChainMultiplication.java
//? java MatrixChainMultiplication
