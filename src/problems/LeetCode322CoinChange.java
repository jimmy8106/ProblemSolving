package problems;

public class LeetCode322CoinChange {
  public static void main(String[] args) {
    int[] coins = { 1, 3, 5 };
    int amount = 11;
    int c = coinChange(coins, amount);
    System.out.println(c);
  }

  public static int coinChange(int[] coins, int amount) {
    // 使用DP做
    // 0 1 2 5
    // 0 : 0
    // 1 : 1 1+f(1-1)
    // 2 : 1 1+f(2-1) 1+f(2-2)
    // f(n) = Min( 1 + f(n- c1), 1+ f(n-c2),…, 1+f(n-ck) )

    //bottom up作法
    int dp[] = new int[amount + 1];
    
    //dp[0]預設為0
    //從1開始走
    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;

      for (int j = 0; j < coins.length; j++) {
        // amount小於金幣面額 或者是湊不出來(透過前面操作f()計算)
        if (i - coins[j] < 0 || dp[i - coins[j]] == -1)
          continue;
        //第一個dp[k] = 1 會到第一個最小面額的金幣才出現
        min = Math.min(min, 1 + dp[i - coins[j]]);

      }
      dp[i] = min == Integer.MAX_VALUE ? -1 : min;
    }
    return dp[amount];
  }

}
