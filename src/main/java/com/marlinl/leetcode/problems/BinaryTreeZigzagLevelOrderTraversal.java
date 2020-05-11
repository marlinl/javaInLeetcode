package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/</url>
 * Cost : 0 ms
 * Memory : 38.4 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/11 10:22 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            result.add(new LinkedList<>());
        }
        LinkedList<Integer> linkedList = (LinkedList<Integer>) result.get(level);
        if (level % 2 == 0) {
            linkedList.addLast(root.val);
        } else {
            linkedList.addFirst(root.val);
        }
        depthFirst(root.left, level + 1);
        depthFirst(root.right, level + 1);
    }


}
