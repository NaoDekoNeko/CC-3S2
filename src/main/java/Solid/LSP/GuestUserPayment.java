package Solid.LSP;

public class GuestUserPayment implements NewPayment{
    String name;
    //asigna automaticamente el nombre de usuario "guest" a los invitados
    public GuestUserPayment() {
        this.name = "guest";
    }

    @Override
    public void newPayment(){
        System.out.println("Procesando de "+name+" solicitud actual de pago.");
    }
}
