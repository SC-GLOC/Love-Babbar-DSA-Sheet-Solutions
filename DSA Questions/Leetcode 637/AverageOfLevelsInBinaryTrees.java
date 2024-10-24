import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTrees {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> avgOfLevels = new ArrayList()<>();
        Queue<TreeNode> q1 = new LinkedList<>();

        q1.offer(root);

        while (!q1.isEmpty()) {

            int size = q1.size();
            List<Integer> currLevel = new ArrayList<>();

            while (size != 0) {
                TreeNode currNode = q1.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null) {

                    q1.add(currNode.left);
                }

                if (currNode.right != null) {

                    q1.add(currNode.right);
                }

                size--;
            }

            double sum = 0;

            for (int el : currLevel) {
                sum += el;
            }

            avgOfLevels.add(sum / currLevel.size());
        }

        return avgOfLevels;

    }
}