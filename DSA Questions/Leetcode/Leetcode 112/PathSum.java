
public class PathSum {

    public boolean hasPathSumHelper(TreeNode node, int targetSum, int[] pathSum) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null) {
            pathSum[0] += node.val;
            if (pathSum[0] == targetSum)
                return true;

            return false;
        }

        pathSum[0] += node.val;
        int backUp = pathSum[0];

        boolean leftResult = hasPathSumHelper(node.left, targetSum, pathSum);
        pathSum[0] = backUp;
        boolean rightResult = hasPathSumHelper(node.right, targetSum, pathSum);

        return leftResult || rightResult;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null)
            return false;

        int[] pathSum = { 0 };
        return hasPathSumHelper(root, targetSum, pathSum);

    }

}
