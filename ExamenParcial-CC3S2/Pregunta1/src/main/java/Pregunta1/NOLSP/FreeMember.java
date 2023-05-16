package Pregunta1.NOLSP;

//La clase FreeMember puede unirse a torneos, pero no puede organizar torneos.
public class FreeMember extends Member {
    public FreeMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println(".....");
    }

    //Este método rompe LSP
    @Override
    public void organizeTournament() {
        System.out.println("...");
    }
}
