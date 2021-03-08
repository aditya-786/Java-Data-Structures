package Graph;

import java.util.*;

public class DFSofDisconnectedComponents
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static void DFS_Recursive(ArrayList<ArrayList<Integer>>graph, int source, boolean[] visited)
    {
        visited[source] = true;

        System.out.print(source+" ");

        for (int i : graph.get(source)) if (!visited[i]) DFS_Recursive(graph,i,visited);
    }

    static void DFS(ArrayList<ArrayList<Integer>>graph, int vertices)
    {
        boolean[] visited = new boolean[vertices+1];

        for (int i=0;i<vertices;i++) if (!visited[i]) DFS_Recursive(graph,i,visited);
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

        addEdge(graph,3,4);

        DFS(graph,vertices);
    }
}
