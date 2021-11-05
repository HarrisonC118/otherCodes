package 动态规划;

/**
 * @author: HatcherCheung
 * Date:  2021/10/27
 */
public class CoinClass {
    public static void main(String[] args) {
        System.out.println(coin(2));
    }
    public static int coin(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) {
                min = Math.min(dp[i -1], min);
            }
            if (i >= 5) {
                min = Math.min(dp[i -5], min);
            }
            if (i >= 20) {
                min = Math.min(dp[i -20], min);
            }
            if (i >= 25) {
                min = Math.min(dp[i -25], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

}
