package Trees;

// left --> root --> right

public class InorderTraversal
{
    static void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        inorder(root);
    }
}
