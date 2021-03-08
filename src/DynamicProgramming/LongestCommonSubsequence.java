package DynamicProgramming;

//using memoization

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

    static int[][] memo;

    static int lcs(String s1, String s2, int m, int n){

        if (memo[m][n] != -1) return memo[m][n];

        if (m == 0 || n == 0) memo[m][n] = 0;

        else{

            if (s1.charAt(m-1) == s2.charAt(n-1)) memo[m][n] = 1 + lcs(s1,s2,m-1, n-1);

            else memo[m][n] = Math.max(lcs(s1,s2,m-1,n), lcs(s1,s2,m,n-1));
        }

        return memo[m][n];
    }

    public static void main(String[] args) {

        Scanner fr = new Scanner(System.in);

        String s1 = fr.nextLine();
        String s2 = fr.nextLine();

        int m = s1.length();
        int n = s2.length();

        memo = new int[m+1][n+1];

        for (int i=1;i<=m;i++) for (int j=1;j<=n;j++) memo[i][j] = -1;

        System.out.println(lcs(s1,s2,m,n));
    }
}
