package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class ShortestPathPractice
{
    static class WeightedNode
    {
        int vertex;
        int weight;

        WeightedNode(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }

        int getVertex(){return vertex;}

        int getWeight(){return weight;}
    }

    static void addEdge(ArrayList<ArrayList<WeightedNode>> graph, int edge1, int edge2, int weight)
    {
        WeightedNode weightedNode = new WeightedNode(edge2, weight);
        graph.get(edge1).add(weightedNode);
    }

    static ArrayList<Integer> BFS(ArrayList<ArrayList<WeightedNode>> graph, int[] inDegrees)
    {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : inDegrees) if (i == 0) queue.add(i);

        while (!queue.isEmpty())
        {
            int v = queue.poll();

            list.add(v);

            for (WeightedNode ele : graph.get(v))
            {
                inDegrees[ele.getVertex()]--;

                if (inDegrees[ele.getVertex()] == 0) queue.add(ele.getVertex());
            }
        }

        return list;
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();

        ArrayList<ArrayList<WeightedNode>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

         //graph1
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 1, 3, 2);

        // graph2
//        addEdge(graph, 0, 1, 2);
//        addEdge(graph, 0, 4, 1);
//        addEdge(graph, 1, 2, 3);
//        addEdge(graph, 2, 3, 6);
//        addEdge(graph, 4, 2, 2);
//        addEdge(graph, 4, 5, 4);
//        addEdge(graph, 5, 3, 1);

        int[] inDegrees = new int[vertices];

        for (int i=0;i<graph.size();i++) for (WeightedNode ele : graph.get(i)) inDegrees[ele.getVertex()]++;

        ArrayList<Integer> list = BFS(graph, inDegrees);

        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        int source = 1;

        distance[source] = 0;

        for (int ele : list)
        {
            if (distance[ele]!=Integer.MAX_VALUE)
            for (WeightedNode node : graph.get(ele))
            {
                distance[node.getVertex()] = Math.min(distance[node.getVertex()], distance[ele]+node.getWeight());
            }
        }

        for (int i : distance)
        {
            if (i == Integer.MAX_VALUE) System.out.print("INF ");
            else System.out.print(i+" ");
        }
    }
}
