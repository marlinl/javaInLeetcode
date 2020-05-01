package com.marlinl.leetcode.problems;

import java.util.*;

/**
 * Problems source: <url>https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/</url>
 * Cost : 9 ms
 * Memory : 40.8 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/4/30 11:19 PM
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int starter = 0;
        int currentLength = 0;
        Set<Character> index = new HashSet<Character>(s.length());
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!index.add(array[i])) {
                while (starter < i) {
                    char startChar = array[starter];
                    index.remove(startChar);
                    starter++;
                    currentLength--;
                    if (startChar == array[i]) {
                        break;
                    }
                }
                index.add(array[i]);
            }
            currentLength++;
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(characters.lengthOfLongestSubstring("aabaab!bb"));
    }
}
