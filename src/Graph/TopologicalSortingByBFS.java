package Graph;

// this is Kahn's Algorithm

import java.util.*;

public class TopologicalSortingByBFS
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
    }

    static void updateInDegrees(int[] inDegree, ArrayList<ArrayList<Integer>> graph)
    {
        for (int i=0;i<graph.size();i++)
        {
            for (int j : graph.get(i))
            {
                inDegree[j]++;
            }
        }
    }

    static void topologicalSortingByBFS(ArrayList<ArrayList<Integer>>graph, int vertices, int[] inDegree)
    {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<vertices;i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();

            System.out.print(vertex+" ");

            for (int i : graph.get(vertex))
            {
                inDegree[i]--;

                if (inDegree[i] == 0) queue.add(i);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 2, 3);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);

        int[] inDegree = new int[vertices];
        updateInDegrees(inDegree, graph);

        topologicalSortingByBFS(graph, vertices, inDegree);

    }
}
