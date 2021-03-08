package TreeNew;

public class Postorderrecursive {

    static void postorder(Node root){
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value+" ");
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        postorder(root);
    }

}
