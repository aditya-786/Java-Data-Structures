package Graph;

import java.util.*;

public class CycleDetectionInDirectedGraphUsingKahnsAlgorithm
{
    static void addEdge(ArrayList<ArrayList<Integer>>graph, int edge1, int edge2)
    {
        graph.get(edge1).add(edge2);
    }

    static void updateInDegree(ArrayList<ArrayList<Integer>>graph, int vertices, int[] inDegree)
    {
        for (int i=0;i<graph.size();i++)
        {
            for (int j : graph.get(i))
            {
                inDegree[j]++;
            }
        }
    }

    static boolean detectCycle(ArrayList<ArrayList<Integer>>graph, int vertices, int[] inDegree)
    {
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<vertices;i++) if (inDegree[i] == 0) queue.add(i);
        int count = 0;

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();

            for (int i : graph.get(vertex))
            {
                inDegree[i]--;

                if (inDegree[i] == 0) queue.add(i);
            }

            count++;
        }

        return (count != vertices);
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

        addEdge(graph, 0, 1);
        addEdge(graph, 4, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);

        int[] inDegree = new int[vertices];
        updateInDegree(graph, vertices, inDegree);

        System.out.print(detectCycle(graph, vertices, inDegree));
    }
}
