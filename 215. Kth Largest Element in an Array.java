//215. Kth Largest Element in an Array
/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.


*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k<1 || nums.length<k){
            throw new RuntimeException("参数错误");
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){//left<right，考虑只有数组只有一个数的情况
            int pos = partion(nums, left, right);
            if (pos == k-1){
                return nums[pos];
            } else if (pos > k-1){// 值在左边
                right = pos-1;
            } else {// 值在右边
                left = pos+1;
            }
            
        }
        throw new RuntimeException("参数错误");//不会走到这一步
    }
    
    //快速排序算法
    public int partion(int[] nums, int low, int high) {// 返回值x，即为数组中排第k的值的下标
		int temp = nums[low];
		int pivotkey = nums[low];// 比pivotkey大的值放在左边，比比pivotkey小的值放在右边
		while (low < high) {
			while (low < high && nums[high] <= pivotkey) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] >= pivotkey) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low] = temp;
		return low;
	}
    
}
