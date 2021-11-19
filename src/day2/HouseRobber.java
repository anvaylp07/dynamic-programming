package day2;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    private static int maxRob(int currentIndex,int []nums, Map<Integer, Integer> hm){

        if (currentIndex>=nums.length)
            return 0;
        if (hm.containsKey(currentIndex))
            return hm.get(currentIndex);

        int robHouse=nums[currentIndex]+maxRob(currentIndex+2, nums, hm);
        int houseNotRobbed=maxRob((currentIndex+1),nums, hm);

        hm.put(currentIndex, Math.max(robHouse, houseNotRobbed));
        return hm.get(currentIndex);
    }
    public static void main(String[] args) {

        System.out.println(maxRob(0,new int[]{2,7,9,3,1}, new HashMap<Integer, Integer>()));
    }
}
