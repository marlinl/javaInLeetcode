package com.marlinl.leetcode.problems;

/**
 * Problems source : <url>https://leetcode-cn.com/problems/gas-station/</url>
 * Cost : 0 ms
 * Memory : 40.2 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/5/9 9:48 PM
 */
public class GasStation {


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            int currentCost = gas[i] - cost[i];
            totalCost += currentCost;
            if (minValue > totalCost) {
                minValue = totalCost;
                minIndex = i;
            }
        }
        minIndex++;
        minIndex = gas.length == minIndex ? 0 : minIndex;
        return totalCost < 0 ? -1 : minIndex;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }


}
