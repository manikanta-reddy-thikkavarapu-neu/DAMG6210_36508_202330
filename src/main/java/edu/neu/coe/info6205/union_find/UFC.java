package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFC {

    public static int count(int n) {
        int noc = 0; Random rc = new Random();
        UF_HWQUPC ufc = new UF_HWQUPC(n, true);

        while (ufc.components()!=1)
        {
            int p = rc.nextInt(n);
            int q = rc.nextInt(n);

            if(!ufc.connected(p,q)) {
                ufc.union(p, q);
                noc++;
            }
        }
        return noc;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for(int i=0; i<8;i++) {
            int n = rand.nextInt(99999);
            System.out.println("No of Objects [n] :" + n + "  No of Pairs [m] :" + count(n));
        }
    }

}
