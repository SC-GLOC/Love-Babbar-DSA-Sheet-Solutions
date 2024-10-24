public class Symmetric Tree
{

    public boolean isSymmetricHelper(TreeNode leftChild, TreeNode rightChild) {

        if (leftChild == null && rightChild == null) {

            return true;
        }

        if (leftChild == null || rightChild == null || leftChild.val != rightChild.val)
            return false;

        return isSymmetricHelper(leftChild.left, rightChild.right)
                && isSymmetricHelper(leftChild.right, rightChild.left);

    }

    public boolean isSymmetric(TreeNode root) {

        return isSymmetricHelper(root.left, root.right);

    }
}