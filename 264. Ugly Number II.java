/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

public class Solution {
    public int nthUglyNumber(int n) {
        if (n<1){
            return 0;
        }
        int primes[] = {2,3,5};
        int len = primes.length;
        int index[] = new int[len];
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for (int j=0; j<len; j++){
                min = Math.min(dp[index[j]]*primes[j], min);// 每次找到最小的丑数
            }
            dp[i] = min;
            for (int j=0; j<len; j++){
                if (dp[i] % primes[j] == 0){
                    index[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
