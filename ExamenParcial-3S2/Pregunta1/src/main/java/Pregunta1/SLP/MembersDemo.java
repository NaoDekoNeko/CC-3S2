package Pregunta1.SLP;

import java.util.List;

public class MembersDemo {
    public static void Main(String[] args){
        List<Member> miembros = List.of(
                new PremiumMember("Abejita Azul"),
                new PremiumMember("Kaperucita Feliz"),
                new FreeMember("Inspectora Motita")
        );
        //todos pueden unirse a un torneo
        for (Member aux: miembros) {
            aux.joinTournament();
        }

    }
}
