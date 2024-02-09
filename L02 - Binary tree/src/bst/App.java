package bst;

public class App {
    public static void main(String[] args) {
        BST bst = new BST<>();
        BST tree = new BST();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);
        tree.insert(90);
        tree.insert(88);

        System.out.println("Tree in inorder: ");
        tree.inorder();

        System.out.println();
        System.out.println();

        System.out.println("Tree in postorder: ");
        tree.postorder();

        System.out.println();
        System.out.println();

        System.out.println("Tree in preorder: ");
        tree.preorder();

        //System.out.println(tree.isLeaf(tree, 88));

    }
}
