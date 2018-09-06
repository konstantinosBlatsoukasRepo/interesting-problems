package kon.blats.trees.height;

import kon.blats.data.structures.tree.TreeNode;

/**
 * Created by kon on 6/9/2018.
 */
public class HeightCalculator {

    private TreeNode root;

    public HeightCalculator(TreeNode root) {
        this.root = root;
    }

    public int calculateHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = root.getLeft() != null ? 1 : 0;
        int rightHeight = root.getRight() != null ? 1 : 0;
        int maxHeight = Math.max(leftHeight, rightHeight);
        return Math.max(calculateHeight(root.getLeft()), calculateHeight(root.getRight())) + maxHeight;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>();
        TreeNode leftRoot = new TreeNode();
        root.setLeft(leftRoot);
        TreeNode rightRoot = new TreeNode();
        root.setRight(rightRoot);

        TreeNode rightRightRoot = new TreeNode();
        rightRoot.setRight(rightRightRoot);

        TreeNode leftLeftRoot = new TreeNode();
        leftRoot.setLeft(leftLeftRoot);

        TreeNode leftLeftLeftRoot = new TreeNode();
        leftLeftRoot.setLeft(leftLeftLeftRoot);

        HeightCalculator calculator = new HeightCalculator(root);
        System.out.println(calculator.calculateHeight());
    }
}
