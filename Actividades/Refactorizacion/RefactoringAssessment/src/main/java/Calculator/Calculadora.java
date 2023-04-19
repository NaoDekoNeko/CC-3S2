package Calculator;

public class Calculadora {
    boolean status;
    public Calculadora() {
        this.status = true;
    }
    public boolean getStatus(){
        return status;
    }

    public double addition(double a, double b) {
        return a+b;
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } else {
            return a / b;
        }
    }

    public double raizCuadrada(double a) {
        if(a<0){
            throw new IllegalArgumentException("No se puede sacar raíz cuadrada " +
                    "Real a un numero negativo");
        }
        return Math.sqrt(a);
    }

    public double potencia(float a, float b) {
        return Math.pow(a,b);
    }
}
