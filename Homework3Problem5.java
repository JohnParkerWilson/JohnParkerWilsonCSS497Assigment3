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
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        printTree(root);
        System.out.println();
        TreeNode balancedRoot = BalanceTree(root);

        printTree(balancedRoot);

    }

    public static TreeNode BalanceTree(TreeNode root) {
        Vector<Integer> NodeList = new Vector<Integer>();
        //Turn tree into list
        TreeToList(root, NodeList);

        //turn list into balanced tree
        return ListToTree(NodeList, 0, NodeList.size()-1);
    }

    public static TreeNode ListToTree(Vector<Integer> NodeList, int start, int end){
        if (start > end) return null;

        //Since list should be inorder, use middle element as root
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(NodeList.get(mid));

        //get left of tree
        root.left = ListToTree(NodeList, start, mid-1);
        //get right of tree
        root.right = ListToTree(NodeList, mid+1, end);

        return root;
    }

    public static void TreeToList(TreeNode root, Vector<Integer> NodeList) {
        //store values inorder
        if (root != null) {
            TreeToList(root.left, NodeList);
            NodeList.add(root.value);
            TreeToList(root.right, NodeList);
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
