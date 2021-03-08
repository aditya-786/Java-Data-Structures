package Graph;

import java.util.*;

public class PrimsUsingMatrix
{
    static int primsMST(int[][] graph, int vertices)
    {
        int res = 0;
        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] mst = new boolean[vertices];
        key[0] = 0;

        for (int i=0;i<vertices;i++)
        {
            int u = -1;

            for (int j=0;j<vertices;j++) {
                if (!mst[j] && (u == -1 || key[j] < key[u])) {
                    u = j;
                }
            }

            mst[u] = true;
            res+=key[u];

            for (int j=0;j<vertices;j++) {
                if (!mst[j] && graph[u][j] != 0 && graph[u][j] < key[j]) {
                    key[j] = graph[u][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        int[][] graph = new int[][]{
                {0,5,8,0},
                {5,0,10,0},
                {8,10,0,20},
                {0,15,20,0}
        };

        //for (int i=0;i<vertices;i++) for (int j=0;j<vertices;j++) graph[i][j] = fr.nextInt();

        System.out.print(primsMST(graph, vertices));
    }
}
