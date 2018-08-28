package kon.blats.trees.minimal;

import kon.blats.data.structures.tree.TreeNode;

/**
 * Created by kon on 28/8/2018.
 */
public class MinimalTreeCreator {
    int[] sorted;

    public MinimalTreeCreator(int[] sorted) {
        this.sorted = sorted;
    }

    public TreeNode<Integer> createMinimalTree() {
        return createMinimalTree(0, sorted.length - 1);
    }

    private TreeNode<Integer> createMinimalTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode<Integer> node = new TreeNode<>();
        node.setData(sorted[middle]);
        node.setLeft(createMinimalTree(start, middle - 1));
        node.setRight(createMinimalTree(middle + 1, end));
        return node;
    }

    public static void main(String[] args) {
        int[] aList = new int[]{1, 2, 4};
        MinimalTreeCreator minimalTreeCreator = new MinimalTreeCreator(aList);
        TreeNode treeNode = minimalTreeCreator.createMinimalTree();
        System.out.println();
    }


}
