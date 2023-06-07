package ejemplos;

public class UserId {
    String id;
    public UserId(){
        var rnd = new NumerosGeneradosAleatoriamente();
        var lanzado = new LanzamientoDados(rnd);
        this.id = lanzado.asText();
    }

    public String getId() {
        return id;
    }
}
