# JohnParkerWilsonCSS497Assigment3

Problem 1.
For this problem I used a slow-fast pointer approach in order to split the list in half and using the middlemost element as the root. By splitting the list in half like this it would give a Time Complexity of O(log n) with a space complexity of O(n) by turning the list into a binary tree.

Problem 2.
To solve this, I made a function that would recursively go through both the preorder and inorder arrays which, first, would get the element from the preorder array then use that to find the index of the inorder arrays needed to build the left and right subtrees, then iterate through each array. The time complxity would be O(n^2) since it is going through two arrays to build the tree and a time complexity of O(n) for the tree itself.

Problem 3.
The solution was to have a sort of depth-first search to the leaves of the tree then slowly building up a subtree going up each level to find the subtree with the maximum sum. The time complexity and space complexity would be O(n) since it recursively go to each node of the tree.

Problem 4.
To solve this, I used a recursive function to go through the tree in preorder traversal and comparing each node's value per row and getting the maximum. Since it is preorder tree traversal the space and time complexity is O(n) for going to each node of the tree.

Problem 5.
For this, I turned the unbalanced tree into a list, storing the values inorder, then used that list to create a balanced tree in preorder. Since the program is going through the list/tree twice the time complexity is O(n^2) with a space complexity of O(n).
