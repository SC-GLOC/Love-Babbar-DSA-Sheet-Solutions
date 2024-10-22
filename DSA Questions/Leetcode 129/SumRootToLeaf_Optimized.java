public class SumRootToLeaf {

    class Solution {

        public int sumOfNumbersHelper(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            sum = sum * 10 + root.val;

            if (root.left == null && root.right == null) {
                return sum;
            }

            // Recursive call on left and right children and return the sum
            return sumOfNumbersHelper(root.left, sum) + sumOfNumbersHelper(root.right, sum);
        }

        public int sumNumbers(TreeNode root) {
            return sumOfNumbersHelper(root, 0);
        }
    }

}