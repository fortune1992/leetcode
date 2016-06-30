public class Solution {
    // 统计正整数n以内（不含n本身）质数的数量
    // 我们仅仅需要检测一个数是否能被比它小的质数整除，如果可以，说明它不是质数，如果都不可以，说明他是质数
    public int countPrimes(int n) {
        // 1不是质数
        if (n<=1){
            return 0;
        }
        
        boolean isPrime[] = new boolean[n];
        for (int i=2; i<n; i++){
            isPrime[i] = true;
        }
         // Loop's ending condition is i * i < n instead of i < sqrt(n)
         // to avoid repeatedly calling an expensive function sqrt().
         // 要得到自然数n以内的全部素数，必须把小于等于sqrt(n)的所有素数的倍数剔除，剩下的就是素数。
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;//合数的倍数均不考虑
            // 去掉合数 第一轮：(2*2)4，6,8，12... 第二轮：(3*3)9,12,15,... 第三轮：(4*4)16,20,24,...
            // 注意此处开始为i*i 对应i*i<n终止条件
            for (int j = i * i; j < n; j += i) {// 若初始j = 2*i;会重复计算，6(2*3,3*2),12(2*6,6+3+3)，不过也不影响结果 
                isPrime[j] = false;// 找出合数
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
           if (isPrime[i]) count++;
        }
        return count;
    }
}
