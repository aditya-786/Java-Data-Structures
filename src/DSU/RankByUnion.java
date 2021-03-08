package DSU;

import java.util.Scanner;

public class RankByUnion {

    static int n;
    static int[] parent;
    static int[] rank;

    static void initialize(){
        for (int i=0;i<n;i++) parent[i] = i;
    }

    static int find(int x){
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    static void union(int x, int y){
        int xRep = find(x);
        int yRep = find(y);

        if (xRep == yRep) return;
        else{
            if (rank[xRep] < rank[yRep]) parent[xRep] = yRep;
            else if (rank[yRep] < rank[xRep]) parent[yRep] = xRep;
            else{
                parent[yRep] = xRep;
                rank[xRep]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner fr = new Scanner(System.in);
        n = fr.nextInt();
        parent = new int[n];
        rank = new int[n];

        initialize();

        union(0,2);
        union(0,4);

        if (find(0) == find(2)) System.out.println("Friends");
        else System.out.println("Not Friends");

        if (find(0) == find(4)) System.out.println("Friends");
        else System.out.println("Not Friends");

        if (find(2) == find(4)) System.out.println("Friends");
        else System.out.println("Not Friends");

        if (find(1) == find(4)) System.out.println("Friends");
        else System.out.println("Not Friends");
    }
}
