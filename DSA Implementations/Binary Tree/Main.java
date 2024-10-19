public class Main {

    public static void main(String[] args) {

        TreeNode T1 = new TreeNode(12);
        TreeNode T2 = new TreeNode(14);
        TreeNode T3 = new TreeNode(13);
        TreeNode T4 = new TreeNode(18);
        TreeNode T5 = new TreeNode(10);
        TreeNode T6 = new TreeNode(21);
        TreeNode T7 = new TreeNode(24);
        TreeNode T8 = new TreeNode(8);
        TreeNode T9 = new TreeNode(7);

        T1.left = T2;
        T1.right = T3;
        T2.left = T4;
        T2.right = T5;
        T3.left = T6;
        T3.right = T7;
        T4.left = T8;
        T4.right = T9;

        BinaryTree BT1 = new BinaryTree();
        BT1.root = T1;

        // BT1.preOrderTraversal(BT1.root);
        // BT1.inOrderTraversal(BT1.root);
        // BT1.postOrderTraversal(BT1.root);
        BT1.levelOrderTraversal();
        BT1.deleteNode(7);
        BT1.levelOrderTraversal();

    }

}
