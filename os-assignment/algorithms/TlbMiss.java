package algorithms;

import util.Constans;

public class TlbMiss {
    public int getAvailableIndex(int[][] tlb) {
        int oldestAssignedIndex = 0, oldestAge = 1000000;
        for (int i = 0; i < Constans.TLB_SIZE; i++) {
            if (tlb[i][0] == -1) {
                return i;
            } else {
                if (tlb[i][2] < oldestAge) {
                    oldestAssignedIndex = i;
                    oldestAge = tlb[i][2];
                }
            }
        }
        return oldestAssignedIndex;
    }
}
