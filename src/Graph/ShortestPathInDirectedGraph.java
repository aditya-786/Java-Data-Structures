package Graph;

import java.util.*;

public class ShortestPathInDirectedGraph
{

    static class WeightedNode
    {
        public int vertex;
        public int weight;

        WeightedNode(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }

        int getVertex()
        {
            return vertex;
        }

        int getWeight()
        {
            return weight;
        }
    }

    static void addEdge(ArrayList<ArrayList<WeightedNode>>graph, int edge1, int edge2, int weight)
    {
        WeightedNode node = new WeightedNode(edge2,weight);
        graph.get(edge1).add(node);
    }

    static void updateInDegrees(int[] arr, ArrayList<ArrayList<WeightedNode>> graph)
    {
        for (int i=0;i<graph.size();i++)
        {

            for (WeightedNode node : graph.get(i)) {
                arr[node.getVertex()]++;
            }
        }
    }

    static ArrayList<Integer> topologicalSortFunction(ArrayList<ArrayList<WeightedNode>>graph, int vertices, int[] inDegree)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<vertices;i++) if (inDegree[i] == 0) queue.add(i);

        while (!queue.isEmpty())
        {
            int vertex = queue.poll();

            list.add(vertex);

            for (WeightedNode i : graph.get(vertex))
            {
                inDegree[i.getVertex()]--;

                if (inDegree[i.getVertex()] == 0) queue.add(i.getVertex());
            }
        }

        return list;
    }

    static void shortestDistance(ArrayList<Integer> list, ArrayList<ArrayList<WeightedNode>> graph, int[] distance)
    {
        for (int ele : list)
        {
            if (distance[ele]!=Integer.MAX_VALUE)
            for (WeightedNode j : graph.get(ele))
            {
                if (distance[j.getVertex()] > (distance[ele]+j.getWeight()))
                {
                    distance[j.getVertex()] = distance[ele]+j.getWeight();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner fr = new Scanner(System.in);

        int vertices = fr.nextInt();
        int source = fr.nextInt();

        ArrayList<ArrayList<WeightedNode>> graph = new ArrayList<>();
        for (int i=0;i<vertices;i++) graph.add(new ArrayList<>());

//        //graph 1
        addEdge(graph, 0, 1, 1);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 2, 3, 4);
        addEdge(graph, 1, 3, 2);

        //graph 2
//        addEdge(graph, 0, 1, 2);
//        addEdge(graph, 0, 4, 1);
//        addEdge(graph, 1, 2, 3);
//        addEdge(graph, 2, 3, 6);
//        addEdge(graph, 4, 2, 2);
//        addEdge(graph, 4, 5, 4);
//        addEdge(graph, 5, 3, 1);

        int[] inDegree = new int[vertices];
        updateInDegrees(inDegree,graph);

        ArrayList<Integer> topologicalSort = topologicalSortFunction(graph, vertices, inDegree);

        int[] distance = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        shortestDistance(topologicalSort, graph, distance);

        for (int i : distance)
        {
            if (i == Integer.MAX_VALUE) System.out.print("INF ");
            else System.out.print(i+" ");
        }
    }
}
