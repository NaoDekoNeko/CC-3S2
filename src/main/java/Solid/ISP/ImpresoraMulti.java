package Solid.ISP;

public class ImpresoraMulti implements Impresora,DispositivoFax,Fotocopiadora{
    @Override
    public void printDocument() {System.out.println("La impresora multifuncion imprime un documento.");}

    @Override
    public void fotocopiar() {System.out.println("La impresora multifuncion realiza una fotocopia");}
    @Override
    public void sendFax(){System.out.println("La impresora multifuncion envía un fax");}
}