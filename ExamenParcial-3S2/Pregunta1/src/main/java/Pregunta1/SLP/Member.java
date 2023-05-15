package Pregunta1.SLP;

//La clase Member es abstracta y representa la clase base para todos los miembros del club de
//ajedrez
public abstract class Member implements IEveryone{
    private final String nombre;
    public Member(String nombre) {
        //había error decía name en vez de nombre
        this.nombre = nombre;
    }
}

