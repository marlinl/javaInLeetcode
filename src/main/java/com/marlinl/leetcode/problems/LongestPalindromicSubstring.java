package com.marlinl.leetcode.problems;


/**
 * Problems source : <url>https://leetcode-cn.com/problems/longest-palindromic-substring/</url>
 * Sorry..do not been solved
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/2 4:56 PM
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
        }
        return "";
    }

    public boolean isPalindromic(String s) {
        int start = 0;
        int end = s.length();
        while (start >= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome(""));
    }
}
