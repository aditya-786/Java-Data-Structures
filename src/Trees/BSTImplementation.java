package Trees;

class Node
{
    int key;
    Node left,right;

    Node(int key)
    {
        this.key = key;
    }
}

public class BSTImplementation
{
    public static void main(String[] args)
    {
        //Node root = null // empty tree

        Node root = new Node(10);

        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.right = new Node(50);
    }
}
