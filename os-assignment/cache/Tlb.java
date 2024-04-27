package cache;

import algorithms.TlbMiss;
import util.Constans;

public class Tlb {
    private final int[][] tlb = new int[Constans.TLB_SIZE][3];
    private final TlbMiss tlbMiss = new TlbMiss();
    private int counter = 0;

    public Tlb() {

        for (int i = 0; i < Constans.TLB_SIZE; i++) {
            tlb[i][0] = -1;
        }
    }

    public boolean doesPageExist(int pageNumber) {
        for (int i = 0; i < Constans.TLB_SIZE; i++) {
            if (tlb[i][0] == pageNumber) {
                return true;
            }
        }
        return false;
    }

    public int getFrameNumber(int pageNumber) {
        for (int i = 0; i < Constans.TLB_SIZE; i++) {
            if (tlb[i][0] == pageNumber) {
                return tlb[i][1];
            }
        }
        return -1;
    }

    public void setFrameNumber(int pageNumber, int frameNumber) {
        if (doesPageExist(pageNumber)) {
            return;
        }

        int index = tlbMiss.getAvailableIndex(tlb);
        tlb[index][0] = pageNumber;
        tlb[index][1] = frameNumber;
        tlb[index][2] = counter;
        counter++;
    }
}
