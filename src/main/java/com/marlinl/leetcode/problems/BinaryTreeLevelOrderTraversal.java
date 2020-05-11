package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/binary-tree-level-order-traversal/</url>
 * Cost : 0 ms
 * Memory : 40.1 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/11 12:08 AM
 */
public class BinaryTreeLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        depthFirst(root, 0);
        return result;
    }

    private void depthFirst(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level || result.get(level) == null) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        depthFirst(root.left, level + 1);
        depthFirst(root.right, level + 1);
    }
    
}
