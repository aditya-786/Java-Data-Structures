package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsPractice
{
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static void BFS(ArrayList<ArrayList<Integer>> graph, int source, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        //System.out.print(source+" ");

        while (!queue.isEmpty())
        {
            int v = queue.poll();

            System.out.print(v+" ");

            for (int ele : graph.get(v))
            {
                if (!visited[ele])
                {
                    visited[ele] = true;
                    queue.add(ele);
                }
            }
        }
    }

    static void BfsDisconnected(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices+1];

        for (int i=0;i<vertices+1;i++) if (!visited[i]) BFS(graph, i, visited);
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<vertices+1;i++) graph.add(new ArrayList<>());

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);

        addEdge(graph,4,5);
        addEdge(graph,4,6);
        addEdge(graph,5,6);

        BfsDisconnected(graph, vertices);
    }
}
