package leetcode.util;

import leetcode.structure.ListNode;
import leetcode.structure.TreeNode;

import java.util.*;

/**
 * create with PACKAGE_NAME
 * USER: husterfox
 */
public class Helper {
    public static TreeNode stringToTreeNode(String input, String nullStr) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals(nullStr)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals(nullStr)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static TreeNode stringToTreeNode(String input) {
        return stringToTreeNode(input, "null");
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ArrayList<String> stringToArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        ArrayList<String> result = new ArrayList<>();
        if (input.length() == 0) {
            return result;
        }
        String[] lists = input.split(",");
        result.addAll(Arrays.asList(lists));
        return result;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }


    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String intArrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        if (array == null) {
            return "null";
        }
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            builder.append(",");
        }
        if (builder.charAt(builder.length() - 1) == ',') {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append("]");
        return builder.toString();
    }

}
