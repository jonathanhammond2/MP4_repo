package com.mycompany.mp42;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
//import javafx.scene.shape.Shape;
public class sortShape extends Rectangle{
    int height;
    int width;
    int xPos;
    int yPos;
    Text txt;

    public sortShape(int height, int width, int X, int Y) {
        super (height, width, X, Y);
        setFill(Color.rgb(50,50,50));
//        this.backRect = backRect;
//        this.sortNum = sortNum;
//        this.indexNum = indexNum;
        
        
        txt = new Text("Rocks");
        txt.setX(super.getX());
        txt.setY(super.getY());

    }
    

}
