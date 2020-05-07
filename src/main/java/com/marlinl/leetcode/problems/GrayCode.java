package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/gray-code/</url>
 * Cost : 1 ms
 * Memory : 37.3 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/7 11:00 PM
 */
public class GrayCode {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        backTrace(n);
        return result;
    }

    public void backTrace(int n) {
        if (n == 0) {
            result.add(0);
            return;
        }
        int pos = n - 1;
        backTrace(pos);
        int offset = 1 << pos;
        int size = result.size();
        while (size > 0) {
            size--;
            int value = offset + result.get(size);
            result.add(value);
        }

    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }
}
