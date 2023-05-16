package Pregunta1.SLP;

//La clase FreeMember puede unirse a torneos, pero no puede organizar torneos.
public class FreeMember extends Member {
    public FreeMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println("As a Free Member, " +
                " you have joined a Tournament.");
    }
}
