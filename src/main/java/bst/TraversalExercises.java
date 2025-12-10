package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();

        // empty tree
        if (root == null) {
            return result;
        }

        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            result.add(current.value); // visit root first

            // push right first so left is popped (processed) first
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> curr = root;

        // keep going while there's somewhere to go (curr) or return to (stack)
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                // go as far left as possible
                stack.push(curr);
                curr = curr.left;
            }

            // now curr is null so we pop the last left node
            TreeNode<T> node = stack.pop();
            result.add(node.value);

            // then go to right subtree
            curr = node.right;
        }

        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // You may use two stacks, or one stack with a previous-node pointer.
        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();

        // empty tree
        if (root == null) {
            return result;
        }

        // create queue to process nodes in level-order
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root); // start with root

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.remove();
            result.add(current.value);

            if (current.left != null) {
                queue.add(current.left); // next level: left
            }

            if (current.right != null) {
                queue.add(current.right); // next level: right
            }
        }

        return result;
    }
}

