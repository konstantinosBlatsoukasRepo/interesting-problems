package kon.blats.data.structures.tree;

/**
 * Created by k.blatsoukas on 8/16/2018.
 */
public class TreeTest {

  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>();
    root.setData(3);

    TreeNode<Integer> leftFirst = new TreeNode<>();
    leftFirst.setData(10);
    TreeNode<Integer> rightFirst = new TreeNode<>();
    rightFirst.setData(23);

    root.setLeft(leftFirst);
    root.setRight(rightFirst);

    TreeNode<Integer> leftSecond = new TreeNode<>();
    leftSecond.setData(56);
    TreeNode<Integer> rightSecond = new TreeNode<>();
    rightSecond.setData(71);

    leftFirst.setLeft(leftSecond);
    leftFirst.setRight(rightSecond);

    TreeNode<Integer> leftThird = new TreeNode<>();
    leftThird.setData(3);
    rightFirst.setLeft(leftThird);

    Tree<Integer> tree = new Tree<>(root);
    tree.inOrderTraversal();
    tree.preOrderTraversal();
    tree.postOrderTraversal();
  }
}
