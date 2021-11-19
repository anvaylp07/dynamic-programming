package day4;

import java.util.HashMap;
import java.util.Map;

public class SubSetDifference {
    private static boolean isSubSetDifferencePossible(int currentIndex, int target,
                                                      int[]nums ,Map<String, Boolean> memo){
        if (currentIndex>=nums.length){
            return target==0?true:false;
        }

        String key=String.valueOf(currentIndex)+"_"+String.valueOf(target);

        if (memo.containsKey(key))
            return memo.get(key);

        boolean considered=false;

        considered=isSubSetDifferencePossible(currentIndex+1, target-nums[currentIndex]
                ,nums, memo);
        if (considered){
            memo.put(key, true);
            return true;
        }
        boolean notConsidered=isSubSetDifferencePossible(currentIndex+1, target, nums, memo);

        memo.put(key,considered||notConsidered);
        return memo.get(key);
    }
    private static int computeSum(int nums[]){
        int sum=0;
        for (int i: nums)
            sum+=i;
        return sum;
    }
    public static void main(String[] args) {

        /* let s1, s2 denote two sets
            given s1-s2=difference ....(1)
            s1+s2=sum (of nums) ....(2)
            Adding 1 and 2
            2s1=sum+difference
            s1=(sum+difference)/2

            sum+diff should be even otherwise return false
        */

        int difference=4;
        int []nums=new int[]{3,2,1,4};

        int sum=computeSum(nums);
        int target=(sum+difference)/2;
        Map <String , Boolean>hm=new HashMap<>();

        if ((sum+difference)%2==0)
            System.out.println(isSubSetDifferencePossible(0,target, nums
                    , hm));
        else System.out.println(false);

        System.out.println(hm.isEmpty());
    }
}
