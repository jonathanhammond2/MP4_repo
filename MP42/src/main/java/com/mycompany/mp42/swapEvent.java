package com.mycompany.mp42;

/**
 *
 * @author jonn
 */
public class swapEvent{
    public int i;
    public int j;

    public swapEvent(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public String toString() {
        return "swapEvent{" + "i=" + i + ", j=" + j + '}';
    }
    
}
