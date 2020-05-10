package com.marlinl.leetcode.problems;

import java.util.Arrays;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/h-index/</url>
 * Cost : 1 ms
 * Memory : 37.3 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/10 11:29 PM
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int maxIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int surplus = citations.length - i;
            int currentIndex = Math.min(citations[i], surplus);
            maxIndex = Math.max(maxIndex, currentIndex);
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex.hIndex(new int[]{51, 44, 22}));
        System.out.println(hIndex.hIndex(new int[]{51, 44, 22, 0}));
    }

}
