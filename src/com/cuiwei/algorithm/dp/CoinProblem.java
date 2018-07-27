package com.cuiwei.algorithm.dp;

/**
 * created by cuiwei on 2018/7/26
 * 假设有 1 元，3 元，5 元的硬币若干（无限），
 * 现在需要凑出 11 元，问如何组合才能使硬币的数量最少？
 * 设函数d(i)表示凑出i元需要的最少硬币数量。
 * i=0时，很显然我们可以知道 d(0) = 0。因为不要凑钱了嘛，当然也不需要任何硬币了。注意这是很重要的一步，其后所有的结果都从这一步延伸开来。
 * i=1时，因为我们有 1 元的硬币，所以直接在第 1 步的基础上，加上 1 个 1 元硬币，得出 d(1) = 1。
 * 当 i = 2 时，因为我们并没有 2 元的硬币，所以只能拿 1 元的硬币来凑。在第 2 步的基础上，加上 1 个 1 元硬币，得出 d(2) = 2。
 * 当 i = 3 时，我们可以在第 3 步的基础上加上 1 个 1 元硬币，得到 3 这个结果。
 * 但其实我们有 3 元硬币，所以这一步的最优结果不是建立在第 3 步的结果上得来的，
 * 而是应该建立在第 1 步上，加上1个3元硬币,得到d(3) = 1。
 * ...
 * 可以看出，除了第 1 步这个看似基本的公理外，其他往后的结果都是建立在它之前得到的某一步的最优解上，加上 1 个硬币得到。得出：
 * d(i) = d(j) + 1  (j<i)
 * 通俗地讲，我们需要凑出 i 元，就在凑出 j 的结果上再加上某一个硬币就行了。'
 * 因此最终公式为：
 * d(i) = min(d(i-vj)+1) )(vj表示硬币的币值，i-vj>=0)
 */

public class CoinProblem {

    //动态规划方法
    public int solution(int[] coins, int total) {
        //保存0-total的最小次数
        int[] tmp = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            if (i == 0) {
                tmp[i] = 0;
                continue;
            }
            int minCoins = total;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (tmp[i - coins[j]] < minCoins) {
                        minCoins = tmp[i - coins[j]];
                    }
                }
            }
            tmp[i] = minCoins + 1;
        }
        return tmp[total];
    }

    //递归方法
    public int solution_recur(int[] coins, int total){
        if (total == 0) return 0;
        int min = total;
        for (int i = 0; i <coins.length ; i++) {
            if (total >= coins[i]){
                int tmp = solution(coins,total - coins[i]);
                if (tmp < min){
                    min = tmp + 1;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        CoinProblem coinProblem = new CoinProblem();
        System.out.println(coinProblem.solution_recur(coins, 32));
    }


}
