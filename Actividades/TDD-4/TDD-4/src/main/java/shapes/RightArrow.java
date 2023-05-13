package shapes;

public class RightArrow implements Shape{
    @Override
    public void draw(Graphics g) {
        g.drawText("\\\\");
        g.drawText(" \\\\");
        System.out.print("  ");
        g.drawHorizontalLine(10);
        //no se puede agregar la punta de esta forma pues la forma en la que
        //se dibuja la linea horizontal hace que al terminar de dibujar,
        //realice un salto de linea
        g.drawText(" //");
        g.drawText("//");
    }
}
