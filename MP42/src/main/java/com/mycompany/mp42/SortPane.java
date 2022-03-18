package com.mycompany.mp42;

import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author rwhitnel
 */
public class SortPane extends TabPane {
    
    // A TabPane object needs Tab objects
    // Before we go on, let's build a ShapeTab class for our tabs
    // Once that's done, let's have an array of ShapeTab objects
    
    private SortTab[] theTabs;
    private int nTabs;

    public SortPane(int nTabs) {
        this.nTabs = nTabs;
        theTabs = new SortTab[nTabs];
        // instantiate a JavaFX Circle for each ShapeTab
//        theTabs[0] = new SortTab()
        for (int i = 0; i < nTabs; i++){
//            Shape[] sortShapes;
            for (int j = 0; j<nTabs; j++){
                double radius = (i + 3) * 30;
                Circle circle = new Circle(radius);
                circle.setFill(Color.rgb(255 - 50 * i, 0, i * 50));
            // build a ShapeTab object with that Circle object
           
            }
            theTabs[i] = new SortTab("Tab " + i);
//            theTabs[i].setText("");
            theTabs[i].setClosable(false);
            getTabs().add(theTabs[i]);
            
        }
    }
    
    
    
}
