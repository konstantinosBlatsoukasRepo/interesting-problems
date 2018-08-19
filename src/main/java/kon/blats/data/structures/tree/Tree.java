package kon.blats.data.structures.tree;

/**
 * Created by k.blatsoukas on 8/16/2018.
 */
public class Tree<T> {

  public TreeNode<T> root;

  public Tree(TreeNode<T> root) {
    this.root = root;
  }

  public void inOrderTraversal() {
    System.out.println("in order traversal");
    inOrderTraversalHelper(root);
  }

  public void inOrderTraversalHelper(TreeNode<T> root) {
    if (root != null) {
      inOrderTraversalHelper(root.getLeft());
      System.out.println(root.getData());
      inOrderTraversalHelper(root.getRight());
    }
  }

  public void preOrderTraversal() {
    System.out.println("in order traversal");
    preOrderTraversalHelper(root);
  }

  public void preOrderTraversalHelper(TreeNode<T> root) {
    if (root != null) {
      System.out.println(root.getData());
      preOrderTraversalHelper(root.getLeft());
      preOrderTraversalHelper(root.getRight());
    }
  }

  public void postOrderTraversal() {
    System.out.println("post order traversal");
    postOrderTraversal(root);
  }

  public void postOrderTraversal(TreeNode<T> root) {
    if (root != null) {
      postOrderTraversal(root.getLeft());
      postOrderTraversal(root.getRight());
      System.out.println(root.getData());
    }
  }
}
