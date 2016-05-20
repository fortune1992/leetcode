/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution {
    private List<Integer> list = new ArrayList<Integer>();//用于记录需要判断的数，当新计算的平方和已经在记录的数中出现，则出现了循环
    public boolean isHappy(int n) {
        if (n < 1){
            return false;
        } else if (n == 1){
            return true;
        } else {
            list.add(n);
            int sum = 0;
            while (n != 0){
                int index = n%10;
                sum += index*index;
                n /= 10;
            }
            // 如果sum和最初的n相同，则判断出现了死循环，需要返回false
            if (list.contains(sum)){
                return false;
            } else {// 否则递归判断
                return isHappy(sum);    
            }
            
        }
        
    }
}
