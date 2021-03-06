/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
    
    public int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i=1; i<nums.length; i++){
            if (count == 0){
                result = nums[i];
                count = 1;
            } else {
                 if (result == nums[i]){
                     count++;
                } else {
                    count--;
                }
            }
        }
        return result;
    }
}
