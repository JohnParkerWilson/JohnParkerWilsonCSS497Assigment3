import java.util.*;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        value = x;
    }
}

class Solution {
    public static void main(String[] args) {
        int [] preorderArray = {3,9,20,15,7};
        int [] inorderArray = {9,3,15,20,7};

        TreeNode root = ArrayToTree(preorderArray, inorderArray);

        printTree(root);
    }

    public static TreeNode ArrayToTree(int [] preOrderArr, int [] inOrderArr) {
        return ArrayToTreeRecursion(preOrderArr, inOrderArr, 0, 0, inOrderArr.length - 1);
    }

    public static TreeNode ArrayToTreeRecursion(int [] preOrderArr, int [] inOrderArr, int preN, int inLeft, int inRight) {
        if (preN > preOrderArr.length - 1 || inLeft > inRight) return null;

        TreeNode root = new TreeNode(preOrderArr[preN]);
        int inN = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrderArr[i] == root.value)
            inN = i;
        }

        root.left = ArrayToTreeRecursion(preOrderArr, inOrderArr, preN + 1, inLeft, inN - 1);
        root.right = ArrayToTreeRecursion(preOrderArr, inOrderArr, preN + 1, inN + 1, inRight);

        return root;
    }

    public static void printTree(TreeNode root)
    {
        if (root != null) {
            System.out.print(root.value + " ");
            printTree(root.left);
            printTree(root.right);

        }
    }
}
