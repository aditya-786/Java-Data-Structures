package DynamicProgramming;

import java.util.*;
import java.io.*;

public class FibonacciUsingMemoization
{
    static int n;
    static int[] memo;

    static int fibo(int n)
    {
        if (memo[n] == -1)
        {
            int res;

            if (n == 0 || n == 1) res = n;
            else res = fibo(n-1) + fibo(n-2);

            memo[n] = res;
        }
        return memo[n];
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        n = fr.nextInt();

        memo = new int[n+1];

        Arrays.fill(memo,-1);

        System.out.println(fibo(n));
    }
}
