package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionInUndirectedGraph
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static boolean DFS(ArrayList<ArrayList<Integer>>graph, int parent, int source, boolean[] visited)
    {
        visited[source] = true;

        for (int v : graph.get(source))
        {
            if (!visited[v]) {if (DFS(graph,source,v,visited)) {return true;}}
            else if (v!=parent) return true;
        }

        return false;
    }

    static boolean CycleDetection(ArrayList<ArrayList<Integer>>graph, int vertices)
    {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
        {
            if (!visited[i])
            {
                if (DFS(graph, -1, i, visited)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

        addEdge(graph,0,1);
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,2,3);
        addEdge(graph,2,4);
        addEdge(graph,4,5);

        System.out.println(CycleDetection(graph,vertices));
    }
}
