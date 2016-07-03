/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    /*
    分析:
    首先注意集合内的元素都是不同的整数，所以尽情产生就好了。产生subsets时,基本思想是由小到大，先产生小的，再
    利用小的产生大集合。具体来说，就是先用0个，1个,...来生成子集然后对新的元素，只要把前面的所有子集中加上个新元素，然后和之前
    的子集和在一起，就是所有子集了。这里能直接加元素，就是因为没有重复的整数.
    */
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        if (nums == null || nums.length == 0){
            return result;
        }
        
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            // 若nums=[1,2,3]
            // i==0时，newLen=1  [] [1]
            // i==1时，newLen=2  [] [1] [2] [1,2]
            // i==2时，newLen=4  [] [1] [2] [1,2] [3] [1,3] [2,3] [1,2,3]
            int newLen = result.size();
            for (int j=0; j<newLen; j++){
                // 注意取出的List集合必须是新的集合，否则修改后会影响原来的值
                temp = new ArrayList<Integer>(result.get(j));//注意此处是result.get(j)!!!
                temp.add(nums[i]);//注意此处是添加nums[i],而不是nums[j].保证没有重复的数字!!!
                result.add(temp);
            }
        }
        return result;
     }
}
