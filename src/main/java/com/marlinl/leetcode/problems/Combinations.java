package com.marlinl.leetcode.problems;

import java.util.*;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/combinations/</url>
 * Cost : 18 ms
 * Memory : 41.5 MB
 * @author marlinl
 * @version 1.0
 * @date 2020/5/2 10:04 PM
 */
public class Combinations {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return result;
        }
        backTrack(1, n, k, new LinkedList<>());
        return result;
    }

    public void backTrack(int start, int end, int k, LinkedList<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        while (start <= end) {
            list.add(start);
            backTrack(start + 1, end, k, list);
            start++;
            list.removeLast();
        }
    }


    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }


}
