package Trees;
import java.util.*;

public class LevelOrderTraversalLineByLine1
{
    static void level_order_traversal_line_by_line(Node root)
    {
        if(root==null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size()>1)
        {
            Node curr = queue.remove();

            if(curr==null)
            {
                System.out.println();
                queue.add(null);
                continue;
            }

            System.out.print(curr.key+" ");
            if(curr.left!=null) queue.add(curr.left);
            if(curr.right!=null) queue.add(curr.right);
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

        level_order_traversal_line_by_line(root);
    }
}
