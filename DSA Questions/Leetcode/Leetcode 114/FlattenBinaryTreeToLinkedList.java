
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        while (root != null) {

            if (root.left == null)
                root = root.right;

            else {

                TreeNode curr = root.left;

                while (curr.right != null) {
                    curr = curr.right;
                }

                curr.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }

    }

}
