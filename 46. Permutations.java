46. Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(result, nums, 0);
        return result;
    }
    
    public void permute(List<List<Integer>> result, int[] nums, int begin){
        if (nums == null || nums.length == 0){
            return;
        }
        if (begin == nums.length-1){
            List<Integer> list = new ArrayList<Integer>();
            for (int i=0; i<nums.length; i++){
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }
        // 此处begin=0负责固定第一个字符：123 213 312 begin=1:132 132 213 231 312 321 begin=2时直接返回结果
        for (int i=begin; i<nums.length; i++){//注意i=begin开始，这个很关键！
            if(i!=begin){
                swap(nums, begin, i);
            }
            permute(result, nums, begin+1);// 注意，此处是begin+1,而不是i,下次循环的起始值.
            if (i!=begin){
                swap(nums, begin, i);//使得数组保持交换前的顺序
            }
        }
    }
    
    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
