
public class InvertBinaryTree {

    public void invertTreeHelper(TreeNode root) {

        if (root == null || (root.left == null && root.right == null))
            return;

        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        root.left = rightChild;
        root.right = leftChild;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root != null)
            invertTreeHelper(root);

        return root;

    }

}
