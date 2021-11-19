package day5;

import java.util.HashMap;
import java.util.Map;

public class CoinChange2 {
    private static int totalNoOfWaysCoinChange(int currentIndex, int targetAmount
            ,int coins[], Map<String, Integer> memo){

        if (targetAmount==0)
            return 1;
        if (currentIndex>=coins.length)
            return 0;

        String key=String.valueOf(currentIndex)+"_"+String.valueOf(targetAmount);

        if (memo.containsKey(key))
            return memo.get(key);

        int considered=0;
        if (targetAmount>=coins[currentIndex])
            considered=totalNoOfWaysCoinChange(currentIndex, targetAmount-coins[currentIndex]
            ,coins, memo);
        int notConsidered=totalNoOfWaysCoinChange(currentIndex+1, targetAmount, coins, memo);

        memo.put(key, considered+notConsidered);

        return memo.get(key);
    }
    public static void main(String[] args) {
        int amount=10;
        amount=500;
        int coins[]=new int[]{10};
        coins=new int[]{3,5,7,8,9,10,11};
        System.out.println(totalNoOfWaysCoinChange(0, amount,
                coins, new HashMap<String, Integer>()));
    }
}
