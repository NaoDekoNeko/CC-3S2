package Contract;

public class TaxCalculator {

    public double calculateTax(double value) {
        /**
         * Este método calcula los impuestos según el valor que se ingresa
         * @param value es el valor inicial.
         * @param taxValue es el valor del impuesto
         * @return el valor del impuesto del producto
         * @throws RuntimeException si value < 0
         * @throws RuntimeException si taxValue < 0
         * Precondition value debe ser positivo
         * Postcondition se devuelve el valor del impuesto siendo este, positivo
         */

        //se puede escribir en vez de lanzar una excepción
        //genera una AssertionError
        assert value >= 0 : "el valor no puede ser negativo";

        /*
        if(value < 0) {
            throw new RuntimeException("El valor tiene que ser positivo");
        }
         */
        double taxValue = 0;

        if(taxValue < 0) {
            throw new RuntimeException("El impuesto no puede ser negativo");
        }
        return taxValue;
    }
}
