package day4;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    //Leetcode 494.
    //VIMP Google, MS, Amazon
    private static int findTargetCount(int currentIndex, int target, int []nums,
                                       Map<String, Integer>memo){

        if (currentIndex>=nums.length){
            return target==0?1:0;
        }
        String key=String.valueOf(currentIndex)+"_"+String.valueOf(target);

        if (memo.containsKey(key))
            return memo.get(key);

        int positiveCase=findTargetCount(currentIndex+1, target-nums[currentIndex], nums, memo);
        int negativeCase=findTargetCount(currentIndex+1, target+nums[currentIndex], nums, memo);
        memo.put(key,positiveCase+negativeCase);

        return memo.get(key);
    }
    public static void main(String[] args) {
        int currentIndex=0;
        int target=3;
        int nums[]=new int[]{2,1,3,1};

        System.out.println(findTargetCount(currentIndex,target,nums,new HashMap<String, Integer>()));
    }
}
