package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/combination-sum/</url>
 * Cost : 6 ms
 * Memory : 40.8 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/4 10:23 PM
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] sorted = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sorted = candidates;
        backTrack(0, 0, target, new LinkedList<>());
        return result;
    }

    private void backTrack(int start, int expect, int target, LinkedList<Integer> list) {
        if (expect == target) {
            result.add(new ArrayList<>(list));
            return;
        } else if (expect > target) {
            return;
        }
        while (start < sorted.length){
            expect += sorted[start];
            list.add(sorted[start]);
            backTrack(start , expect, target, list);
            expect -= sorted[start];
            list.removeLast();
            start++;
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(new int[]{2,3,5}, 8));
    }


}
