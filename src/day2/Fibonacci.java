package day2;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static int nthFibo(int n, Map<Integer, Integer> hm){

        if (n==1)
            return n;
        if (n<1)
            return 0;
        if (hm.containsKey(n))
            return hm.get(n);

        int currentFibo =nthFibo(n-1, hm)+nthFibo(n-2,hm);
        hm.put(n, currentFibo);

        return currentFibo;
    }
    public static void main(String[] args) {

        System.out.println(nthFibo(0, new HashMap<Integer, Integer>()));
    }
}
