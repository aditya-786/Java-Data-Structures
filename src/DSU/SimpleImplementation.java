package DSU;

import java.util.Scanner;

public class SimpleImplementation {

    static int n;
    static int[] parent;

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
        if (xRep == yRep) return; // because they are already in same set
        else parent[yRep] = xRep;
    }

    public static void main(String[] args) {
        Scanner fr = new Scanner(System.in);
        n = fr.nextInt();
        parent = new int[n];
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

// Find is searching the root of every x, and in the worst case the representation, i.e, tree can be skewed,
// so in the worst case, it will take O(n) time for find(x)
// and same for union also
