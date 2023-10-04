import java.util.*;

class ListNode {
    int value;
    ListNode next;
    public ListNode() {}
    public ListNode(int value) { this.value = value; }
    public ListNode(int value, ListNode next) { this.value = value; this.next = next; }
}
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
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = ListToBalancedTree(head);

        printTree(root);

    }

    public static TreeNode ListToBalancedTree(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.value);

        ListNode slow = head;
        ListNode fast = head.next;
        //Get end and middle of list with  fast and slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(mid.value);
        root.left = ListToBalancedTree(head);
        root.right = ListToBalancedTree(mid.next);
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
