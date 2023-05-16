package Pregunta1.NOLSP;

//La clase Member es abstracta y representa la clase base para todos los miembros del club de
//ajedrez
public abstract class Member {
    private final String nombre;
    public Member(String nombre) {
        //había error decía name en vez de nombre
        this.nombre = nombre;
    }
    public abstract void joinTournament();
    public abstract void organizeTournament();
}

