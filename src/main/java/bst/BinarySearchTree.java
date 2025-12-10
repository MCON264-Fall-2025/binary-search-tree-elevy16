package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, value);
        }
        // ignore duplicates for this assignment
        return node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    // --------- Recursive Traversals ----------

    public List<T> preorderRecursive() {
        List<T> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(TreeNode<T> node, List<T> out) {
        // Root -> Left -> Right

        // base case
        if (node == null) {
            return;
        }
        // root
        out.add(node.value);
        // left
        preorderRecursive(node.left, out);
        // right
        preorderRecursive(node.right, out);
    }

    public List<T> inorderRecursive() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode<T> node, List<T> out) {
        // Left -> Root -> Right

        // base case
        if (node == null) {
            return;
        }
        // left
        inorderRecursive(node.left, out);
        // root
        out.add(node.value);
        // right
        inorderRecursive(node.right, out);
    }

    public List<T> postorderRecursive() {
        List<T> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void postorderRecursive(TreeNode<T> node, List<T> out) {
        // Left -> Right -> Root

        // base case
        if (node == null) {
            return;
        }
        // left
        postorderRecursive(node.left, out);
        // right
        postorderRecursive(node.right, out);
        // root
        out.add(node.value);
    }

    // --------- Level-order (Breadth-First) ----------

    public List<T> levelOrder() {
        List<T> result = new ArrayList<>();
        // if root is null, return empty list
        if (root == null) {
            return result;
        }

        // create queue to process nodes in level-order
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root); // enqueue root

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove(); // dequeue node
            result.add(current.value);            // add node.value to result
            if (current.left != null) {           // enqueue left children
                queue.add(current.left);
            }
            if (current.right != null) {          // enqueue right children
                queue.add(current.right);
            }
        }

        return result;
    }

    // --------- Unified API via TraversalType ----------

    public List<T> getByTraversal(TraversalType type) {
        // dispatch based on traversal type
        return switch (type) {
            case PREORDER -> preorderRecursive();
            case INORDER -> inorderRecursive();
            case POSTORDER -> postorderRecursive();
            case LEVEL_ORDER -> levelOrder();
        };
    }
}
