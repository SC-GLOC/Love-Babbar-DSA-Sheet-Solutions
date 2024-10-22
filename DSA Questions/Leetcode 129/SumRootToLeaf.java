import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {

    List<Integer> rootToLeaf = new ArrayList()<>();

    public void sumOfNumbersHelper(TreeNode root, int sum) {

        if (root == null) {

            return;
        }

        if (root.left == null && root.right == null) {

            sum = sum * 10 + root.val;
            rootToLeaf.add(sum);
            return;
        }

        sum = sum * 10 + root.val;
        int backUp = sum;
        sumOfNumbersHelper(root.left, sum);
        sum = backUp;
        sumOfNumbersHelper(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {

        sumOfNumbersHelper(root, 0);
        int res = 0;
        for (int el : rootToLeaf) {
            System.out.print(el + " ");
            res += el;
        }

        return res;

    }

}
