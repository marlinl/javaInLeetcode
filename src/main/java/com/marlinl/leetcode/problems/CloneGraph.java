package com.marlinl.leetcode.problems;

import java.util.*;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/clone-graph/</url>
 * Cost : 37 ms
 * Memory : 40.1 MB
 * 
 * @author marlinl
 * @version 1.0
 * @date 2020/5/9 11:01 PM
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    private Map<Integer, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        depthFirst(node);
        return cloneMap.get(node.val);
    }

    private Node depthFirst(Node source) {
        if (cloneMap.containsKey(source.val)) {
            return cloneMap.get(source.val);
        }
        Node current = new Node(source.val);
        cloneMap.put(source.val, current);
        List<Node> list = new ArrayList<>();
        for (Node neighbor : source.neighbors) {
            Node cloneNode = depthFirst(neighbor);
            list.add(cloneNode);
        }
        current.neighbors = list;
        return current;
    }


    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();
        Node case1 = new Node(1);
        Node case2 = new Node(2);
        Node case3 = new Node(3);
        Node case4 = new Node(4);
        List<Node> c1 = new ArrayList<>();
        c1.add(case2);
        c1.add(case4);
        List<Node> c2 = new ArrayList<>();
        c2.add(case1);
        c2.add(case3);
        List<Node> c3 = new ArrayList<>();
        c3.add(case2);
        c3.add(case4);
        List<Node> c4 = new ArrayList<>();
        c4.add(case1);
        c4.add(case3);
        case1.neighbors = c1;
        case2.neighbors = c2;
        case3.neighbors = c3;
        case4.neighbors = c4;
        Node result = cloneGraph.cloneGraph(case1);
        c1 = null;
        c2 = null;
        c3 = null;
        c4 = null;
        System.out.println(result);
    }


}
