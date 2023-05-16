package Pregunta1.SLP;

//La clase PremiumMember puede unirse a torneos de ajedrez u organizar tales torneos
//también.
public class PremiumMember extends Member implements IPremium{
    public PremiumMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println("As a Premium Member, " +
                " you have joined a Tournament.");
    }

    @Override
    public void organizeTournament() {
        System.out.println("As a Premium Member, " +
                " you are organizing a Tournament.");
    }
}

