package Lec10;

import edu.princeton.cs.algs4.Queue;

public class BST <Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left, right;
    private int size;

    public Node(Key key, Value value, int size) {
      this.key = key;
      this.value = value;
      this.size = size;
    }
  }
  /**
   * Initializes a tree
   */
  public BST() {

  }

  /**
   *
   * @return {@code true} if tree is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * @return size of tree
   */
  public int size() {
    return size(root);
  }

  /**
   * @param cur: current Node
   * @return size of that node
   */
  private int size(Node cur) {
    if(cur == null) return 0;
    return cur.size;
  }

  /**
   * Return the value of key
   * @param key the key need to get
   * @return the value of rh given key if the ky is in the tree
   * and {@code null} if the key is not in tree
   */
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node root, Key key) {
    if(key == null) throw new IllegalArgumentException("null key");
    if(root == null) return null;
    int compare = key.compareTo(root.key);
    if(compare == 0) return root.value;
    if(compare < 0) return get(root.left, key);
    // We can ensure compare larger than zero.
    return get(root.right, key);
  }

  /**
   * Throw exception if key is null or value is null
   * @param key Key want to put in tree
   * @param value value associate with key
   */
  public void put(Key key, Value value) {
    if(key == null) throw new IllegalArgumentException("null key");
    if(value == null) {
      throw new IllegalArgumentException("null value");
    }
    root = put(root, key, value);
  }

  private Node put(Node root, Key key, Value value) {
    if(root == null) return new Node(key, value, 1);
    int compare = key.compareTo(root.key);
    if(compare < 0) root.left = put(root.left, key, value);
    if(compare > 0) root.right = put(root.right, key, value);
    root.size = 1 + size(root.left) + size(root.right);
    return root;
  }

  /**
   * Return number of key in tree is less than given key
   * @param key given key
   * @return number of key less than given key in tree
   */
  public int rank(Key key) {
    return rank(key, root);
  }

  private int rank(Key key, Node root) {
    if(root == null) return 0;
    int compare = key.compareTo(root.key);
    if(compare == 0) return size(root.left);
    if(compare > 0) return 1 + size(root.left) + rank(key, root.right);
    return rank(key, root.left);
  }

  /**
   * return all keys of tree when inorder traversal
   * @return Iterable of all keys we walk through when inorder traversal
   */
  public Iterable<Key> keys() {
    Queue<Key> q = new Queue<Key>();
    inorder(root, q);
    return q;
  }

  private void inorder(Node root, Queue<Key> q) {
    if(root == null) return;
    inorder(root.left, q);
    q.enqueue(root.key);
    inorder(root.right, q);
  }

  /**
   * delete node with min key in tree
   */
  public void deleteMin() {
    deleteMin(root);
  }

  private Node deleteMin(Node root) {
    if(root.left == null) return root.right;
    root.left = deleteMin(root.left);
    root.size = size(root.left) + size(root.right) + 1;
    return root;
  }
}
