package shapes;

import java.util.ArrayList;
import java.util.List;

public class Shapes {
     private final List<Shape> allShapes = new ArrayList<>();
     private final Graphics graphics;
     public Shapes(Graphics graphics){
         this.graphics=graphics;
     }

     public void add(Shape s) {
         allShapes.add(s);
     }
     public void draw(){
         allShapes.forEach(shape -> shape.draw(graphics));
     }
     //este es un ejemplo de codigo que no usa polimorfismo y
     //se apoya en multiples switch, lo que dificulta la agregación de nuevas formas
     /*
     public void draw(Graphics g) {
         for (Shape s : allShapes) {
             switch (s.getType()) {
                 case "textbox":
                     var t = (TextBox) s;
                     //g.drawText(t.getText());
                     break;
                 case "rectangle":
                     var r = (Rectangle) s;
                     r.draw(g);
                     //for (int row = 0;
                     //     row < r.getHeight();
                     //     row++) {
                     //    g.drawLine(0, r.getWidth());
                     //}
             }
         }
     }
      */
 }
