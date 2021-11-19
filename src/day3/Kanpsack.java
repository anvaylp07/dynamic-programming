package day3;

import java.util.HashMap;
import java.util.Map;

public class Kanpsack {
    //Geeks for Geeks
    private static int findMaxProfit(int capacity, int currentIndex, int []weights, int[]profits, Map<String,Integer> hm){

        if (currentIndex>=profits.length)
            return 0;

        int considered=0;
        String key=String.valueOf(currentIndex)+"_"+String.valueOf(capacity);
        if (hm.containsKey(key))
            return hm.get(key);

        if (weights[currentIndex]<=capacity)
            considered=profits[currentIndex]
                +findMaxProfit(capacity-weights[currentIndex],currentIndex+1,weights,profits,hm);
        int notConsidered=findMaxProfit(capacity,currentIndex+1,weights,profits,hm);

        hm.put(key, Math.max(considered,notConsidered));

        return hm.get(key);
    }
    public static void main(String[] args) {
        //findMaxProfit()

        int capacity=5;
        int currentIndex=0;
        int []weights=new int[]{1,2,3};
        int []profits=new int[]{1,5,3};


        System.out.println(findMaxProfit(capacity,currentIndex,weights,profits,new HashMap<String, Integer>()));
    }
}
