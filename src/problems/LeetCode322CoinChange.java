package problems;

public class LeetCode322CoinChange {
  public static void main(String[] args) {
    int[] coins = { 1, 3, 5 };
    int amount = 11;
    int c = coinChange(coins, amount);
    System.out.println(c);
  }

  public static int coinChange(int[] coins, int amount) {
    // �ϥ�DP��
    // 0 1 2 5
    // 0 : 0
    // 1 : 1 1+f(1-1)
    // 2 : 1 1+f(2-1) 1+f(2-2)
    // f(n) = Min( 1 + f(n- c1), 1+ f(n-c2),�K, 1+f(n-ck) )

    //bottom up�@�k
    int dp[] = new int[amount + 1];
    
    //dp[0]�w�]��0
    //�q1�}�l��
    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;

      for (int j = 0; j < coins.length; j++) {
        // amount�p��������B �Ϊ̬O�ꤣ�X��(�z�L�e���ާ@f()�p��)
        if (i - coins[j] < 0 || dp[i - coins[j]] == -1)
          continue;
        //�Ĥ@��dp[k] = 1 �|��Ĥ@�ӳ̤p���B�������~�X�{
        min = Math.min(min, 1 + dp[i - coins[j]]);

      }
      dp[i] = min == Integer.MAX_VALUE ? -1 : min;
    }
    return dp[amount];
  }

}
