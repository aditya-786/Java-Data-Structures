package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinChange {

    static int coinChange(int[] coins, int sum, int n)
    {
        int[][] dp = new int[sum+1][n+1];

        for (int i=1;i<=sum;i++) dp[i][0] = 0;
        for (int i=0;i<=n;i++) dp[0][i] = 1;

        for (int i=1;i<=sum;i++)
        {
            for (int j=1;j<=n;j++)
            {
                dp[i][j] = dp[i][j-1];

                if (coins[j-1]<=i) dp[i][j] = dp[i][j] + dp[i - coins[j - 1]][i];
            }
        }

        return dp[sum][n];
    }

    public static void main(String[] args) {

        Scanner fr = new Scanner(System.in);

        int n = fr.nextInt();

       int[] coins = new int[n];
       for (int i=0;i<n;i++) coins[i] = fr.nextInt();

        int sum = fr.nextInt();

        System.out.println(coinChange(coins,sum,n));
    }
}
