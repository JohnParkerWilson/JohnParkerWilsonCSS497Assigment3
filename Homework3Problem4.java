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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        List<Integer> largestValues = LargestValueRow(root);

        System.out.println(largestValues);

    }

    public static List<Integer> LargestValueRow(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();
        LargestValueRecursion(values, root, 0);
        return values;
    }

    public static void LargestValueRecursion(List<Integer> values, TreeNode root, int height) {
        if (root != null) {
          if(height == values.size()) values.add(root.value);
          else values.set(height, Math.max(values.get(height), root.value));

          LargestValueRecursion(values, root.left, height+1);
          LargestValueRecursion(values, root.right, height+1);
      }
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
