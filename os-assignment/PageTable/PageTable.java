package PageTable;

import util.Constans;

public class PageTable {
    private final int[] pageTable = new int[Constans.RAM_SIZE];

    public PageTable() {

        for (int i = 0; i < Constans.RAM_SIZE; i++) {
            pageTable[i] = -1;
        }
    }

    public boolean doesFrameExist(int pageNumber) {
        if (pageNumber < 0 || pageNumber > Constans.PAGE_SIZE) {
            return false;
        }
        return pageTable[pageNumber] != -1;
    }

    public int getFrameNumber(int pageNumber) {
        if (pageNumber < 0 || pageNumber > Constans.PAGE_SIZE) {
            return -1000000;
        }
        if (pageTable[pageNumber] == -1) {
            return -1000000;
        }
        return pageTable[pageNumber];
    }

    public void setFrameNumber(int pageNumber, int frameNumber) {
        if (pageNumber < 0 || pageNumber > Constans.PAGE_SIZE) {
            return;
        }
        pageTable[pageNumber] = frameNumber;
    }
}