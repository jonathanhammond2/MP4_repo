package com.mycompany.mp42;

import static com.mycompany.mp42.SortSearchAlgs.*;
import java.util.LinkedList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.animation.Animation.Status;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
/**
 *
 * @author jonn
 */
public class SortTab extends Tab {
    // ShapeTab will display by default a Shape object that is provided to it
//    private Shape[] sortShapes;
//    private LinkedList<sortShape> sortShapes = new LinkedList<>();
    // Step 1
    private final Button randomize;
    private final Button addElement;
    private final Button removeElement;
    private final Button quickSort;
    private final Button swap;
    private final Random rand = new Random();
    LinkedList<Text> txt = new LinkedList<>();
    sortText text = new sortText();
//    int[] nums = new int[];

    public SortTab(String string) {
        super(string);
//        this.theShape = theShape;
        // Step 2
        randomize = new Button("Randomize");
        addElement = new Button("Add Element");
        removeElement = new Button("Remove Element");
        quickSort = new Button("quickSort");
        swap = new Button("swap elements");

       
        BorderPane sortBox = new BorderPane();
        sortBox.setTop(randomize);
        sortBox.setCenter(quickSort);
        sortBox.setBottom(swap);
        
        for (int i = 0; i<20; i++){
            txt.add(new Text(20.*i,150.,i+""));
            text.add(new Text(20.*i+20,150,i+""));
            sortBox.getChildren().add(text.get(i));
            text.get(i).setX(text.get(i).getX());
            text.get(i).setY(text.get(i).getY());
        }
        
        setContent(sortBox);
//       
        randomize.setOnAction(this::processButtonPress);
        quickSort.setOnAction(this::processButtonPress);
        swap.setOnAction(this::processButtonPress);

   }
  
//     public void animateSwitchElements(LinkedList<Text> t, int i, int j){
//         Path path = new Path();
//         Path path2 = new Path();
        
//         double X = t.get(i).getX();
//         double Y = t.get(i).getY();
        
//         double X2 = t.get(j).getX();
//         double Y2 = t.get(j).getY();
        
//         double toX = (X + X2)/2;
        
//         path.getElements().addAll(new MoveTo(X,Y),new LineTo(toX,125), new LineTo(X2,Y2));
//         path2.getElements().addAll(new MoveTo(X2,Y2),new LineTo(toX, 125), new LineTo(X,Y));
//         //build a PathTransition that has a duration, a path, and a target
        
//         PathTransition pathT = new PathTransition(Duration.millis(2000), path, t.get(i));
//         PathTransition pathT2 = new PathTransition(Duration.millis(2000), path2, t.get(j));
        
//         pathT.statusProperty().addListener(new ChangeListener<Status>() {

//         @Override
//         public void changed(ObservableValue<? extends Status> observableValue,
//                             Status oldValue, Status newValue) {
//             if(newValue==Status.STOPPED){
//                 // swapTxtElements(text,i,j);
//                 text.swapTxtElements(i, j);
// //                try{
// ////                animateSwitchElements(text,i+1,j-1);}
// //                catch(IndexOutOfBoundsException e){
// //                    System.out.println("done");
// //                }
                
//             }            
//         }});
//         pathT.setCycleCount(1);
//         pathT.play();
        
//         pathT2.setCycleCount(1);
//         pathT2.play();
        
//         text.get(i).setX(X2);
//         text.get(i).setY(Y2);
        
//         text.get(j).setX(X);
//         text.get(j).setY(Y);
//     }
    
    
    public void processButtonPress(ActionEvent evt) {
        if (evt.getTarget().equals(randomize)){
            for (int i = 0; i<text.size(); i++){
            // text.get(i).setText(rand.nextInt(text.size()) + "");
                text.setIntVal(i, rand.nextInt(text.size()));
                text.normText(i);
            }
        }
        else if (evt.getTarget().equals(quickSort)){
//            int[] nums = new int[text.size()];
//            for (int i = 0; i<text.size(); i++){
//                nums[i]=Integer.parseInt(text.get(i).getText());
//            }
            // quickSort(nums,0,text.size());
        //    text.quickSortTxt(0, text.size());
//            text.clearSortEvts();
            text.makeQuickSortEvents(0,text.size());
            System.out.println(text.sortEvts.toString());
            // text.animateQSort();
            text.processFinalInt(text.sortEvts().poll());
//            text.insertionSortTxt(0, text.size());
            
//            for (int i = 0; i<text.size(); i++){
//            text.get(i).setText(nums[i] + "");
//            }
        }
        
        else {
//            swapTxtElements(text,0,1);
//              animateSwitchElements(text,0,text.size()-1);
                // text.animateSwitchElements(0, 9);
                text.swapTxtElements(0, 8);
            }
            
        }
        
    }
    
