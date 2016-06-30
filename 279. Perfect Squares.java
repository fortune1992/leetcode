/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

public class Solution {
    public int numSquares(int n) {
        // 考察动态规划， 如果一个数x可以表示为一个任意数a加上一个平方数b∗b，也就是x=a+b∗b，
        // 那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1（因为b∗b已经是平方数了）。
        int count[] = new int[n+1];
        count[1] = 1;
        for (int i=2; i<=n;i++){
            count[i] = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++){
                // 注意count[0]为0这很关键，即a==0不需要额外的数来表示！同时j*j已是一个平方数，故需要加1
                count[i] = Math.min(count[i], count[i-j*j]+1);
            }
        }
        return count[n];
    }
}
