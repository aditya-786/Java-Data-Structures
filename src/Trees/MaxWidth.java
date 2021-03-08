package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    static int maxWidth(Node root)
    {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty())
        {
            int count = queue.size();
            res = Math.max(res,count);

            for (int i=0;i<count;i++)
            {
                Node curr = queue.poll();

                if (curr.left!=null) queue.add(curr.left);
                if (curr.right!=null) queue.add(curr.right);
            }
        }
        return res;
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

        System.out.println(maxWidth(root));
    }
}
