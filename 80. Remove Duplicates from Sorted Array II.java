/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    // nums已经排好序
    public int removeDuplicates(int[] nums) {
        // 如果iter扫到的当前元素在index之前已经存在两个（注意，由于A是排好序的，因此只需要判断前两个就行），
        // 那么iter继续前进。否则将iter指向的元素加入index，index与iter一起前进。
        return removeDuplicates(nums, 2);
    }
    
    public int removeDuplicates(int[] nums, int k){
        if (nums == null){
            throw new RuntimeException("参数错误");
        }
        if (nums.length <= k){
            return nums.length;
        }
        int iter = k;
        int index = k;
        for (; iter<nums.length; iter++){
            if (nums[iter] != nums[index-2]){
                nums[index]=nums[iter];
                index++;
            }
        }
        return index;
    }
}
