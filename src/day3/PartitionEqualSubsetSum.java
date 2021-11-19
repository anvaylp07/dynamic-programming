package day3;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    //Leetcode 416
    private static boolean isPartitionPossible(int currentIndex, int sum, int []nums, Map<String, Boolean>hm){

        if (currentIndex>=nums.length)
            return false;
        if (sum==0)
            return true;

        String currentKey=String.valueOf(currentIndex)+"_"+String.valueOf(sum);
        if (hm.containsKey(currentKey))
            return hm.get(currentKey);

        boolean considered=false;

        if (nums[currentIndex]<=sum)
            considered=isPartitionPossible(currentIndex+1, sum-nums[currentIndex],nums, hm);

        if (considered){//lazy OR approach. In a||b if a is true, value of b doesn't matter. we can ignore b
            hm.put(currentKey,true);
            return true;
        }
        boolean notConsidered=isPartitionPossible(currentIndex+1,sum,nums, hm);

        hm.put(currentKey, considered||notConsidered);
        return hm.get(currentKey);
    }
    private static boolean canPartition(int[] nums) {
        int sum=0;
        for (int i: nums){
            sum+=i;
        }
        if (sum%2!=0)
            return false;
        return isPartitionPossible(0,sum/2,nums, new HashMap<String , Boolean>());
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,5,11,5};

        //int[] nums=new int[]{1,2,3,5};

        System.out.println(canPartition(nums));
    }

}
