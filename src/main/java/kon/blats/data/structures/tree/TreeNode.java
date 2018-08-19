package kon.blats.data.structures.tree;

/**
 * Created by k.blatsoukas on 8/16/2018.
 */
public class TreeNode<T> {
  private TreeNode left;
  private TreeNode right;
  private T data;

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
