/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/

public class Solution {
    // 丑数的定义是：1是丑数，丑数可以表示为有限个2、3、5的乘积
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n<1 || primes == null || primes.length==0){
            return 0;
        }
        int len = primes.length;
        int index[] = new int[len];//保存primes中每项倍数的次数
        int dp[] = new int[n];//保存最终得到的丑数结果
        dp[0] = 1;
        for (int i=1; i<n; i++){
            int min = Integer.MAX_VALUE;
            //注意：index[j]
            // i==1 index[j]=0
            // i==2 index[0]=1 dp[0]=1 dp[1]=2
            // i==3 index[0]=2 dp[0]=1 dp[2]=2 dp[3]=4
            // i==4 index[0]=3 dp[0]=1 dp[2]=2 dp[3]=4 dp[4]=7
            // i==5 index[0]=3 index[1]=1 dp[0]=1 dp[1]=2 dp[2]=4 dp[3]=7 dp[4]=8
            // ...
            // i==11 index[0]=8 index[1]=3 index[2]=2 index[3]=1
            // dp[0]=1 dp[1]=2 dp[2]=4 dp[3]=7 dp[4]=8 ... dp[11]=32
            for (int j=0; j<len; j++){
                min = Math.min(dp[index[j]]*primes[j], min);
            }
            dp[i] = min;
            for (int j=0; j<len; j++){
                if (dp[i]%primes[j] == 0){
                    index[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
