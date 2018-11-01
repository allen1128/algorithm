package com.xl.algo;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidHelper(root, null, null);
    }

    public boolean isValidHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        return (min == null || node.val > min)
                && (max == null || node.val < max)
                && isValidHelper(node.left, min, node.val)
                && isValidHelper(node.right, node.val, max);
    }
}
