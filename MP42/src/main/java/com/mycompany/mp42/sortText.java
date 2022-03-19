package com.mycompany.mp42;

//import static com.mycompany.tabtest.SortSearchAlgs.insertionSort;
//import static com.mycompany.tabtest.SortSearchAlgs.swapElements;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author jonn
 */
public class sortText extends LinkedList<Text>{
    Queue<swapEvent> sortEvts = new LinkedList<>();
    
    // public Text set(int index, Text element){
    //     super.set(index, element);
    // }
    public void setIntVal(int index, int num){
        super.get(index).setText(num + "");
    }

    public Queue sortEvts(){
        return sortEvts;
    }

    public int[] getIntArr(){
        int[] arr = new int[super.size()];
        for(int i = 0; i<super.size(); i++)
            arr[i] = getIntVal(i);
        return arr;
    }

    // public void updateIntList(){
    //     for(int i = 0; i<super.size(); i++)
            // intVals.set(i, getIntVal(i));
    // }

    // public ArrayList<Integer> getIntList(){
    //     return intVals;
    // }
    public void clearSortEvts(){
        sortEvts.clear();
    }
    public void makeQuickSortEvents(int first, int last){
        int[] arr = getIntArr();
        quickSortEvts(arr,0,arr.length);
        System.out.print("\nsorted arr: ");
        for (int i: arr)
            System.out.print(i + "\t");
        System.out.println();
        
    }
    public void quickSortEvts(int[] a, int first, int last) {
        //only to quickSort for more than three array elements
        if (last - first > 3) {
            //what's the middle element
            int mid = first + (last - first) / 2;
            //sort the first, middle, and last elements
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
            if (a[mid] > a[last - 1]) {
                swapElements(a, mid, last - 1);
            }
            if (a[first] > a[mid]) {
                swapElements(a, first, mid);
            }
            
            //move the pivot to the end
            swapElements(a, mid, last - 1);
            int pivotValue = a[last - 1];
            
            //start from both sides and work inwatds
            int indexFromLeft = first + 1;
            int indexFromRight = last - 2;
            boolean done = false; //this becomes true once all the elements
            //are positioned relative to the pivot
            while (!done) {
                //move from the left until we find an element greater than the pivot
                while (a[indexFromLeft] < pivotValue) {
                    indexFromLeft++;
                }
                //move from the right until we have an element less than the pivot
                while (a[indexFromRight] > pivotValue) {
                    indexFromRight--;
                }
                //provided that the left and right pointers have not crossed
                //swap the elemeents
                if (indexFromLeft < indexFromRight) {
                    swapElements(a, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } else {
                    done = true;
                }
            }
            //once the pointers cross, move the pivot into the correct location
            swapElements(a, last - 1, indexFromLeft);
            
            //let's use quickSort to sort each subarray on either side of the pivot
            quickSortEvts(a, first, indexFromLeft);
            quickSortEvts(a, indexFromLeft + 1, last);
            
        } else {
            insertionSort(a, first, last);
        }
    }

    public void swapElements(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        sortEvts.add(new swapEvent(i, j));
    }

    public static void insertionSort(int[] a, int first, int last){
        for (int i = first+1; i<last; i++){
            int next = a[i];
            //start searching backwards for where we're going to insert next
            int iFill = i - 1;
            while (iFill >=0 && next < a[iFill]){
                //As long as this is true, move the iFill element up one to make space
                a[iFill+1] = a[iFill];
                iFill--;
            }
            //When we're done, we know where our element belongs
            a[iFill + 1] = next;
        }
    }

    
    public void insertionSortTxt(int first, int last){
        for (int i = first+1; i<last; i++){
            Text next = super.get(i);
            //start searching backwards for where we're going to insert next
            int iFill = i - 1;
            while (iFill >=0 && getIntVal(next) < getIntVal(iFill)){
                //As long as this is true, move the iFill element up one to make space
                super.set(iFill+1, super.get(iFill));
//                getIntVal(iFill+1) = getIntVal(iFill);
                iFill--;
            }
            //When we're done, we know where our element belongs
//            a[iFill + 1] = next;
            super.set(iFill+1, next);
        }
    }
    
    public int getIntVal(Text t){
            return Integer.parseInt(t.getText());
    }
    
    public int getIntVal(int i){
        return Integer.parseInt(super.get(i).getText());
    }
    
//     public void setIntVal(int i, int j){
// //        super.set(i, new Text(j + ""));
//         super.get(i).setText(j + "");
//     }
    
    public void swapTxtElements(int i, int j){
       Text temp = super.get(i);
       super.set(i, super.get(j));
       super.set(j, temp);
   }
    
    public void animateQSort(){
//        Iterator<swapEvent> sortIterator = sortEvts.iterator();
//        
//        while(sortIterator.hasNext()){
//            swapEvent e = sortIterator.next();
//            animateSwitchElements(e);
//            System.out.println(e);
//        }
        animateSwitchElements((swapEvent) sortEvts.poll());
    }
    
    public void animateSwitchElements(swapEvent e){
        int i = e.i;
        int j = e.j;
        Path path = new Path();
        Path path2 = new Path();
        
        double X = super.get(i).getX();
        double Y = super.get(i).getY();
        
        double X2 = super.get(j).getX();
        double Y2 = super.get(j).getY();
        
        double toX = (X + X2)/2;
        
        path.getElements().addAll(new MoveTo(X,Y),new LineTo(toX,125), new LineTo(X2,Y2));
        path2.getElements().addAll(new MoveTo(X2,Y2),new LineTo(toX, 125), new LineTo(X,Y));
        //build a PathTransition that has a duration, a path, and a target
        
        PathTransition pathT = new PathTransition(Duration.millis(2000), path, super.get(i));
        PathTransition pathT2 = new PathTransition(Duration.millis(2000), path2, super.get(j));
        
        pathT.statusProperty().addListener(new ChangeListener<Animation.Status>() {

        @Override
        public void changed(ObservableValue<? extends Animation.Status> observableValue,
                            Animation.Status oldValue, Animation.Status newValue) {
            if(newValue==Animation.Status.STOPPED){
                swapTxtElements(i,j);
                
                
                try
                {
                swapEvent e = (swapEvent) sortEvts.poll();
                animateSwitchElements(e);
                System.out.println(e.toString());
                }
                catch(Exception e){
                    System.out.println("done");
                }
                
            }            
        }});
        pathT.setCycleCount(1);
        pathT.play();
        
        pathT2.setCycleCount(1);
        pathT2.play();
        
        super.get(i).setX(X2);
        super.get(i).setY(Y2);
        
        super.get(j).setX(X);
        super.get(j).setY(Y);
    }
}
