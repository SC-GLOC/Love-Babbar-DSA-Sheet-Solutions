import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {

            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        boolean reverse = false;

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

            if (!reverse) {

                result.add(currLevel);
            } else {

                List<Integer> reverseCurrLevel = new ArrayList<>();

                for (int i = 0; i < currLevel.size(); i++) {

                    reverseCurrLevel.add(currLevel.get(currLevel.size() - 1 - i));
                }

                result.add(reverseCurrLevel);
            }

            reverse = !reverse;

        }

        return result;

    }
}