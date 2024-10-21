import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBT {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<Integer> rightSideView = new ArrayList<>();

        Queue<TreeNode> q1 = new LinkedList<>();

        q1.offer(root);

        while (!q1.isEmpty()) {

            int size = q1.size();

            while (size != 0) {

                TreeNode currNode = q1.poll();

                if (size == 1) {

                    rightSideView.add(currNode.val);
                }

                if (currNode.left != null)
                    q1.add(currNode.left);

                if (currNode.right != null)
                    q1.add(currNode.right);

                size--;
            }
        }

        return rightSideView;

    }

}
