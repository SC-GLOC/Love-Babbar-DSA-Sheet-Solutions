import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q1 = new LinkedList<>();

        q1.offer(root);

        while (!q1.isEmpty()) {

            int size = q1.size();

            List<Integer> currLevel = new ArrayList<>();

            while (size != 0) {

                TreeNode currNode = q1.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {

                    q1.offer(currNode.left);
                }

                if (currNode.right != null) {

                    q1.offer(currNode.right);
                }

                size--;

            }

            result.add(currLevel);
        }

        return result;

    }
}