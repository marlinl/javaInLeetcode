package com.marlinl.leetcode.problems;

import java.util.Arrays;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/sort-an-array/</url>
 * Cost : 5 ms
 * Memory : 47.6 MB
 *
 * @auther marlinl
 * @date 2020-05-12 17:09
 */
public class SortAnArray {


    public int[] sortArray(int[] nums) {
        return quicksort(nums);
    }

    private int[] quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[right];
        int l = left, r = right;
        while (l < r) {
            while (array[l] <= pivot && l < r) {
                l++;
            }
            while (array[r] >= pivot && l < r) {
                r--;
            }
            swap(array, l, r);
        }
        swap(array, right, r);
        quicksort(array, left, r - 1);
        quicksort(array, r + 1, right);
    }


    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        SortAnArray sortAnArray = new SortAnArray();
        System.out.println(Arrays.toString(sortAnArray.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}
