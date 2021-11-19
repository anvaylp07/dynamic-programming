package day1;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    //leetcode problem no 746
    private static int findMinCost(int currentIndex, int []cost, Map <Integer, Integer>hm){
        //target index is len of cost
        if (currentIndex>=cost.length){
            if (currentIndex==cost.length) return 0;
            else return 1000;// don't pass INT_max. It'll overflow and give -vw value
        }
        if (hm.containsKey(currentIndex)){
            return hm.get(currentIndex);
        }
        int oneStep=cost[currentIndex]+findMinCost(currentIndex+1, cost, hm);
        int twoStep=cost[currentIndex]+findMinCost(currentIndex+2, cost, hm);

        int minCost= Math.min(oneStep, twoStep);
        hm.put(currentIndex, minCost);

        return minCost;
    }

    public static void main(String[] args) {
        int[] cost =new int[]{10,15,20};
        Map<Integer, Integer>hm=new HashMap<>();
        int start0Step=findMinCost(0,cost, hm);
        int start1Step= hm.get(1);//findMinCost(1,cost, hm);


        int minCost= Math.min(start0Step, start1Step);
        //int minCost=Math.min(start0Step, start1Step);
        System.out.println(minCost);
    }
}
