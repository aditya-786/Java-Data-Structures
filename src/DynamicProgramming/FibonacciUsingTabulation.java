package DynamicProgramming;

import java.util.Scanner;

public class FibonacciUsingTabulation {
    public static void main(String[] args) {
        Scanner fr = new Scanner(System.in);

        int n = fr.nextInt();
        int[] fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i=2;i<=n;i++) fibo[i] = fibo[i-1] + fibo[i-2];

        System.out.println(fibo[n]);
    }
}
