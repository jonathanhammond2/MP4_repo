package com.mycompany.mp42;

public class pointerEvent {
    public int currentIndex;
    public int previousIndex;
    public boolean leftPointer;

    public pointerEvent(int c, int p, boolean leftPointer){
        this.currentIndex = c;
        this.previousIndex = p;
        this.leftPointer = leftPointer;
    }
    @Override
    public String toString(){
        return "pointerEvent{" + currentIndex + ", " 
        + previousIndex + ", " + "leftPointer: " + leftPointer +"}";
    }
}
