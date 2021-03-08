package Graph;

import java.util.*;

public class DetectCycleInDirectedGraph
{

    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
    }

    static boolean DFS(ArrayList<ArrayList<Integer>>graph, boolean[] visited, int source, boolean[] recStack)
    {
        visited[source] = true;
        recStack[source] = true;

        for (int vertex : graph.get(source))
        {
            if (!visited[vertex] && DFS(graph,visited, vertex, recStack)) return true;
            else if (recStack[vertex]) return true;
        }

        recStack[source] = false;
        return false;
    }

    static boolean cycleDetection(ArrayList<ArrayList<Integer>>graph, int vertices)
    {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i=0;i<vertices;i++)
        {
            if (!visited[i])
            {
                if (DFS(graph,visited, i, recStack)) return true;
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

        addEdge(graph, 0, 1);
        addEdge(graph, 2, 1);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 5);
        addEdge(graph, 5, 3);

        System.out.println(cycleDetection(graph, vertices));
    }
}
