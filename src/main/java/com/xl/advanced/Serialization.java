package com.xl.advanced;

import com.xl.algo.MinMeetingRooms;

public class Serialization {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = "[" + serialize(root.left) + "]" + root.val  + "[" + serialize(root.right) + "]";
        //System.out.println(result);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data.equals("[]")) {
            return null;
        }

        int leftPos = findChild(data, 0);
        String leftStr = data.substring(1, leftPos);

        int valuePos = data.indexOf('[', leftPos + 1);
        int val = Integer.valueOf(data.substring(leftPos + 1, valuePos));
        String rightStr = data.substring(valuePos+1, data.length()-1);

        TreeNode node = new TreeNode(val);

        System.out.println("leftStr: " + leftStr);
        System.out.println("rightStr: " + rightStr);
        node.left = deserialize(leftStr);
        node.right = deserialize(rightStr);

        //System.out.println(node);
        return node;
    }

    public int findValue(String data, int pos) {
        int val = Integer.valueOf(data.substring(pos, data.indexOf('[', pos)));
        System.out.println(val);
        return val;
    }

    public int findChild(String data, int pos) {
        int i = pos;
        int count = 0;

        for (; i < data.length(); i++) {
            if (data.charAt(i) == '[') {
                count++;
            } else if (data.charAt(i) == ']') {
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        //System.out.println("i:" + i);
        return i;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(2);
        treeNode.right.right.right.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.left.right = new TreeNode(3);
        treeNode.right.left.left = new TreeNode(2);
        treeNode.right.left.left.right = new TreeNode(13);

        Serialization s = new Serialization();
        System.out.println(s.deserialize(s.serialize(treeNode)));
    }
}
