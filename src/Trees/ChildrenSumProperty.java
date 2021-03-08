package Trees;

public class ChildrenSumProperty {

    static boolean isCSum(Node root)
    {
        if (root == null) return true;

        if (root.left==null && root.right==null) return true;

        int sum = 0;

        if (root.left!=null) sum+=root.left.key;
        if (root.right!=null) sum+=root.right.key;

        return (root.key == sum && isCSum(root.left) && isCSum(root.right));
    }

    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(5);
        root.left.right = new Node(2);
        root.left.left = new Node(3);

        System.out.println(isCSum(root));
    }
}
