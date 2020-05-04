package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem source : <url>https://leetcode-cn.com/problems/generate-parentheses/</url>
 * Commit on leedcode at 2020-5-4 22:12:00. But there is something wrong with leetcode website
 * 
 * @author marlinl
 * @version 1.0
 * @date 2020/5/3 11:52 PM
 */
public class GenerateParentheses {

    private Set<String> result = new HashSet<>();
    private int limit = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>(result);
        }
        StringBuilder charset = new StringBuilder();
        charset.append("(");
        limit = n * 2;
        backTrack(1, n - 1, charset);
        return new ArrayList<>(result);
    }

    private void backTrack(int leftBracket, int remainingLeft, StringBuilder current) {
        if (current.length() == limit) {
            result.add(current.toString());
            return;
        }
        if (remainingLeft == 0) {
            current.append(")");
            backTrack(leftBracket - 1, remainingLeft, current);
            current.deleteCharAt(current.length() - 1);
            return;
        }
        if (leftBracket == 0) {
            current.append("(");
            backTrack(leftBracket + 1, remainingLeft - 1, current);
            current.deleteCharAt(current.length() - 1);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                current.append(")");
                backTrack(leftBracket - 1, remainingLeft, current);
                current.deleteCharAt(current.length() - 1);
            } else {
                current.append("(");
                backTrack(leftBracket + 1, remainingLeft - 1, current);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
