import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {

        root = null;

    }

    public void preOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        System.out.print(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    public void inOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);

    }

    public void postOrderTraversal(TreeNode node) {

        if (node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.value + " ");

    }

    public void levelOrderTraversal() {

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty()) {

            TreeNode currNode = q1.poll();
            System.out.print(currNode.value + " ");

            if (currNode.left != null) {
                q1.offer(currNode.left);
            }

            if (currNode.right != null) {
                q1.offer(currNode.right);
            }
        }
    }

    public void insertNode(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null)
            root = newNode;

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty()) {

            TreeNode currNode = q1.poll();

            if (currNode.left == null) {
                currNode.left = newNode;
                System.out.println("Node Inserted Successfully");
                break;
            }

            if (currNode.right == null) {
                currNode.right = newNode;
                System.out.println("Node Inserted Successfully");
                break;
            }

            q1.add(currNode.left);
            q1.add(currNode.right);
        }
    }

    public boolean searchNode(int val) {

        if (root == null) {

            System.out.println("No Tree Exists For Searching");
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);

        while (!q1.isEmpty()) {

            TreeNode currNode = q1.poll();

            if (currNode.value == val) {

                return true;
            }

            if (currNode.left != null) {
                q1.offer(currNode.left);
            }

            if (currNode.right != null) {
                q1.offer(currNode.right);
            }

        }

        return false;

    }

    private TreeNode findNodeForDeletion(int val) {

        if (root == null) {

            System.out.println("No Tree Exists For Searching");
            return null;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        TreeNode currNode;
        while (!q1.isEmpty()) {

            currNode = q1.poll();

            if (currNode.value == val) {

                return currNode;
            }

            if (currNode.left != null) {
                q1.offer(currNode.left);
            }

            if (currNode.right != null) {
                q1.offer(currNode.right);
            }

        }

        return null;

    }

    private TreeNode findDeepestNode() {

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        TreeNode currNode = null;
        while (!q1.isEmpty()) {

            currNode = q1.poll();

            if (currNode.left != null) {
                q1.offer(currNode.left);
            }

            if (currNode.right != null) {
                q1.offer(currNode.right);
            }

        }

        return currNode;

    }

    private void deleteDeepestNode() {

        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        TreeNode previousNode = null, presentNode = null;

        while (!q1.isEmpty()) {
            previousNode = presentNode;
            presentNode = q1.poll();

            if (presentNode.left == null) {
                previousNode.right = null;
                return;

            } else if (presentNode.right == null) {
                previousNode.left = null;
                return;

            }

            q1.add(presentNode.left);
            q1.add(presentNode.right);
        }

    }

    public void deleteNode(int val) {

        if (!searchNode(val)) {

            System.out.println("There is no node for deletion");
            return;

        }

        TreeNode nodeToBeDeleted = findNodeForDeletion(val);
        TreeNode deepestNode = findDeepestNode();

        nodeToBeDeleted.value = deepestNode.value;

        deleteDeepestNode();

        System.out.println("Node Deleted!");

    }
}
