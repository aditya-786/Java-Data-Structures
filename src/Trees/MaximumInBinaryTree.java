package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumInBinaryTree
{
    static int getMaximum_iteratively(Node root) // not good for proper binary tree
    {
        int res = Integer.MIN_VALUE;

        if(root==null) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                Node curr = queue.remove();

                if(curr.key>res) res = curr.key;

                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return res;
    }

    static int getMaximum_recursively(Node root) // not good for skewed tree
    {
        if(root==null) return Integer.MIN_VALUE;
        else return Math.max(root.key,Math.max(getMaximum_recursively(root.left),getMaximum_recursively(root.right)));
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

        System.out.println(getMaximum_recursively(root));
        System.out.println(getMaximum_iteratively(root));
    }
}
