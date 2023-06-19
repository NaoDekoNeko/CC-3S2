package Contract;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Basket {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Map<Product, Integer> basket = new HashMap< >();

    public void add(Product product, int qtyToAdd) {
        /**
         * El método agrega un producto al carrito
         * @param product es un producto de la tienda
         * @param qtyToAdd es la cantidad de producto a agregar
         * Preconditions: el producto debe existir en la tienda y no debe estar agotado,
         * la cantidad agregada debe ser positiva
         * Postconditions: agrega el producto al carrito y especifica la cantidad agregada
         */

        assert product != null : "El producto no debe ser vacío";
        assert qtyToAdd > 0 : "La cantidad a agregar debe ser positiva";
        BigDecimal oldTotalValue = totalValue;

        assert basket.containsKey(product) : "El producto no existe";
        assert totalValue.compareTo(oldTotalValue) == 1 : "No se agregó el producto";
        /*
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :
                "El valor total no puede ser negativo";
         */
        assert invariant() : "El valor total no puede ser negativo";
    }
    public void remove(Product product) {
        assert product != null : "El producto no debe ser vacío";
        assert basket.containsKey(product) : "No se encontró el producto";



        assert !basket.containsKey(product) : "No se eliminó el producto";
        /*
        assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :
                "El valor total no puede ser negativo .";
         */
        assert invariant() : "El valor total no puede ser negativo";
    }
    private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public int quantityOf(Product product) {
        assert basket.containsKey(product);
        return basket.get(product);
    }

    public Set<Product> products() {
        return Collections.unmodifiableSet(basket.keySet());
    }
    @Override
    public String toString() {
        return "BasketCase{" +
                "totalValue=" + totalValue +
                ", basket=" + basket +
                '}';
    }
}
