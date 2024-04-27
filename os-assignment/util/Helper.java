package util;

public class Helper {
    public int getPhysicalAddress(int frameNumber, int offset) {
        return frameNumber * Constans.RAM_SIZE + offset;
    }

    public byte getByteFromMemory(int frameNumber, int offset, byte[][] memory) {
        if (frameNumber < 0 || frameNumber > Constans.PAGE_SIZE
                || offset < 0 || offset > Constans.PAGE_SIZE) {
            return -1;
        } else if (isFrameEmpty(frameNumber, memory)) {
            return -1;
        }
        return memory[frameNumber][offset];
    }

    public boolean isFrameEmpty(int frameNumber, byte[][] memory) {
        if (frameNumber < 0 || frameNumber > Constans.PAGE_SIZE) {
            return false;
        }
        return memory[frameNumber][0] == -1
                && memory[frameNumber][1] == -1;
    }
}