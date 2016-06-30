/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
*/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        boolean result = false;
        if (nums == null || nums.length<3){
            return result;
        }
        if (increasingCount(nums) >= 3){
            result = true;
        }
        return result;
    }
    
    public int increasingCount(int[] nums){
        int dp[] = new int[nums.length];
        int max = 1;
        for (int i=0; i<nums.length; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
