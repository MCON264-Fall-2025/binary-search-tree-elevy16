# Reflection Questions

### Why does inorder traversal of a BST return elements in sorted order?
In an inorder traversal, every node is sorted from left subtree to root to right subtree.
So once you do inorder on the whole tree it will first list all the smaller values, then the current value, and then the larger values.
Doing this recursively for every node builds a sorted list.

### Give an example of an insertion order that produces a highly unbalanced BST.
### What does the inorder traversal look like for that tree?
If you insert `1,2,3,4,5` in sorted order, it will build a highly unbalanced tree. 
It will look kind of like a linked list.
Inorder traversal is left -> root -> node. Every node has only one right child. The result is a sorted badly shaped tree.

### In your own words, explain the differences between:

### Recursive vs iterative traversal
**Recursive:**
The function calls itself
clone looks clean and like how you think about trees
deep trees can risk stack overflow, and it can be harder to debug
**Iterative:**
You use your own data structure -- Stack for DFS style, Queue for BFS style
Functions don't call itself, it uses loops
More control because avoids deep recursion issues
Can be more complex to write, but it shows what recursion is doing under the hood

### Depth-first vs breadth-first traversal
**Depth-first traversal (DFS):**
Goes as deep as possible down one path before backing up -- preorder, inorder, postorder
Usually implemented with a recursion or stack
Good when want to explore whole subtrees or when don't care about levels
**Breadth-First traversal (BFS):**
Visits nodes level by level
Implemented with a queue
Good when levels matter

### When might you prefer a breadth-first traversal in a real application?
It is useful when the concepts of level or distance are important. For example:
- Finding the shortest graph in an unweighted graph
- Processing or displaying a tree level by level, such as showing all employees by management level in an organization chart.
