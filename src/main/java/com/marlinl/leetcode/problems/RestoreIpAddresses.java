package com.marlinl.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Problems source : <url>https://leetcode-cn.com/classic/problems/restore-ip-addresses/description/</url>
 * Ready to commit leetcode website
 *
 * @auther marlinl
 * @date 2020-05-08 14:47
 */
public class RestoreIpAddresses {

    private List<String> result = new ArrayList<>();
    private int endPosition = 0;

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        char[] chars = s.toCharArray();
        int[] string = new int[chars.length];
        endPosition = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            string[i] = Character.getNumericValue(chars[i]);
        }
        backTrace(0, 1, string, new LinkedList<>());
        return result;
    }

    private void backTrace(int index, int figure, int[] string, LinkedList<Integer> current) {
        if (figure == 5) {
            if (index == string.length) {
                StringBuilder sb = new StringBuilder();
                for (Integer integer : current) {
                    sb.append(integer).append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
                return;
            } else {
                return;
            }
        }
        if (figure > 4 && index < string.length) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            int end = index + i;
            int nextIndex = end + 1;
            if (end > endPosition) {
                return;
            }
            int ip = getIp(string, index, end);
            if (ip == -1) {
                continue;
            }
            current.add(ip);
            backTrace(nextIndex, figure + 1, string, current);
            current.removeLast();
        }
    }

    private int getIp(int[] string, int start, int end) {
        int figure = 1;
        int value = 0;
        while (start <= end) {
            value += string[end] * figure;
            figure *= 10;
            end--;
        }
        if (value <= 255 && value >= 0) {
            return value;
        }
        return -1;
    }

    public static void main(String[] args) {
        RestoreIpAddresses addresses = new RestoreIpAddresses();
        System.out.println(addresses.restoreIpAddresses("25525511135"));
    }
}
