package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintKLevelNodes
{
    static void printKLevelNodes(Node root, int K)
    {
        if(root==null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            count++;

            if(count==K)
            {
                for(int i=0;i<size;i++)
                {
                    Node curr = queue.remove();

                    System.out.print(curr.key+" ");
                }
                break;
            }

            for(int i=0;i<size;i++)
            {
                Node curr = queue.remove();

                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(30);
        root.right = new Node(20);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        printKLevelNodes(root,K);
    }
}
