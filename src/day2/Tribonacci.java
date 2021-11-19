package day2;

import java.util.HashMap;

public class Tribonacci {

    private static int nthTribo(int n, HashMap<Integer, Integer> hm) {
        
        if (n==2)
            return 1;
        if (n==1)
            return n;
        if (n<1)
            return 0;
        
        if (hm.containsKey(n))
            return hm.get(n);
        
        int currentTribo=nthTribo(n-1, hm)+nthTribo(n-2, hm)+nthTribo(n-3, hm);
        hm.put(n, currentTribo);
        
        return currentTribo;
    }
    
    public static void main(String[] args) {
        System.out.println(nthTribo(4, new HashMap<Integer, Integer>()));
    }

    
}
