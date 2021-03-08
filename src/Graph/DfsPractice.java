package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsPractice
{
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
        graph.get(edge2).add(edge1);
    }

    static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int source)
    {
        visited[source] = true;

        System.out.print(source+" ");

        for (int i : graph.get(source)) if (!visited[i]) DFS(graph, visited, i);
    }

    static void Dfs(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices+1];

        for (int i=0;i<vertices+1;i++) if (!visited[i]) DFS(graph, visited, i);
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i=0;i<vertices+1;i++) graph.add(new ArrayList<>());

        addEdge(graph,0,1);
        addEdge(graph,0,2);
        addEdge(graph,1,2);

        addEdge(graph,3,4);

        Dfs(graph, vertices);
    }
}
