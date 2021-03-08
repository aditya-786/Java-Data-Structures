package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInUndirectedGraph
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static void DFS(ArrayList<ArrayList<Integer>>graph, int source, int vertices, double[] distance)
    {
        boolean[] visited = new boolean[vertices+1];

        for (int i=0;i<vertices;i++) distance[i] = Double.POSITIVE_INFINITY;

        visited[source] = true;
        distance[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();

            for (int i : graph.get(vertex))
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    distance[i] = distance[vertex]+1;
                    queue.add(i);
                }
            }
        }
    }

    static void printShortestDistance(double[] distance)
    {
        for (double i : distance) System.out.print((int)i+" ");
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);
        addEdge(graph,4,4);

        double[] distance = new double[vertices];

        DFS(graph,0,vertices,distance);

        printShortestDistance(distance);
    }
}
