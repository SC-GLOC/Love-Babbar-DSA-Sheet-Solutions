import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostorderAndInorder {

    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> inorderIndexMap, int[] index,
            int start, int end) {

        if (start > end)
            return null;

        int rootVal = postorder[index[0]];
        int rootIndex = inorderIndexMap.get(rootVal);
        index[0]--;

        TreeNode root = new TreeNode(rootVal);

        root.right = buildTreeHelper(inorder, postorder, inorderIndexMap, index, rootIndex + 1, end);
        root.left = buildTreeHelper(inorder, postorder, inorderIndexMap, index, start, rootIndex - 1);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {

            inorderIndexMap.put(inorder[i], i);
        }

        int[] index = { postorder.length - 1 };
        int start = 0;
        int end = postorder.length - 1;

        return buildTreeHelper(inorder, postorder, inorderIndexMap, index, start, end);

    }

}
