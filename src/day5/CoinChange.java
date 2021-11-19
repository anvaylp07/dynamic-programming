package day5;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    //Leetcode 322
    private static int max=100000;
    private static int minNoOfCoins(int currentIndex, int targetAmount, int []coins,
                                    Map<String, Integer> memo){
        if (targetAmount==0)
            return 0;
        if (currentIndex>=coins.length)
            return max;
        String key=String.valueOf(currentIndex)+"_"+String.valueOf(targetAmount);

        if (memo.containsKey(key))
            return memo.get(key);

        int considered=max;

        if (coins[currentIndex]<=targetAmount){
            considered=1+minNoOfCoins(currentIndex, targetAmount-coins[currentIndex],
                    coins, memo);
        }

        int notConsidered=minNoOfCoins(currentIndex+1, targetAmount, coins, memo);
        memo.put(key, Math.min(considered, notConsidered));

        return memo.get(key);
    }
    public static void main(String[] args) {

        int []coins=new int[]{1,2,5};
        int amount=11;
        int minCoins=minNoOfCoins(0,amount, coins, new HashMap<String, Integer>());

        System.out.println(minCoins==max?-1:minCoins);
    }
}
