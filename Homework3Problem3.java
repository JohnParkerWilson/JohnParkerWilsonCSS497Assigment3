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
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(MaximumPathSum(root));
    }

    public static int MaximumPathSum(TreeNode root) {
        return MaxPathRecur(root, 0);
    }

    public static int MaxPathRecur(TreeNode root, int max) {
        if(root == null) return 0;

        //Get the Maximum of left and right subtrees
        int leftMax = MaxPathRecur(root.left, max);
        int rightMax = MaxPathRecur(root.right, max);

        //get the maximum between the node value and the maximums of the left/right trees
        int thisMax = Math.max(root.value, Math.max(leftMax, rightMax) + root.value);

        //Get the maximum between previous maximum and maximum of left/right trees
        int totalMax = Math.max(thisMax, root.value + leftMax + rightMax);

        //Get max of whole tree
        max = Math.max(max, totalMax);

        return totalMax;
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
