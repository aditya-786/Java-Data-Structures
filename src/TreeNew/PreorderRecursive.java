package TreeNew;

class Node{
    Node left;
    Node right;
    int value;

    Node(int value){
        this.value = value;
    }
}

public class PreorderRecursive {

    static void preorder(Node root){
        if (root == null) return;

        System.out.print(root.value+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        preorder(root);

    }

}
