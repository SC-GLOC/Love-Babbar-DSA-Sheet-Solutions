import java.util.HashMap;
import java.util.Map;

public class BInaryTreeFromPreorderAndInorder {

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, Map<Integer, Integer> inorderFreqMap, int[] index,
            int start, int end) {

        if (start > end)
            return null;

        int rootVal = preorder[index[0]];
        int rootIndex = inorderFreqMap.get(rootVal);

        index[0]++;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, inorder, inorderFreqMap, index, start, rootIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, inorderFreqMap, index, rootIndex + 1, end);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderFreqMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {

            inorderFreqMap.put(inorder[i], i);
        }

        int[] index = { 0 };

        return buildTreeHelper(preorder, inorder, inorderFreqMap, index, 0, preorder.length - 1);

    }
}