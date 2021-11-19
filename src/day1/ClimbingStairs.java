package day1;

import java.util.HashMap;

public class ClimbingStairs {
    //leetcode problem no 70
    private static int noOfWaysToClimbStairs(int targetStep, int currentStep, HashMap<Integer, Integer> hm){
        if (currentStep>=targetStep)
            return currentStep==targetStep?1:0;

        if (hm.containsKey(currentStep))
            return hm.get(currentStep);

        int oneStep=noOfWaysToClimbStairs(targetStep,currentStep+1, hm);
        int twoStep=noOfWaysToClimbStairs(targetStep, currentStep+2,hm);

        hm.put(currentStep, oneStep+twoStep);

        return oneStep+twoStep;
    }
    public static void main(String[] args) {
        System.out.println(noOfWaysToClimbStairs(4,0, new HashMap<Integer, Integer>()));
    }
}
