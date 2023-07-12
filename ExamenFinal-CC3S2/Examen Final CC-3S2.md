# Examen Final CC-3S2

Cada pregunta está dentro de su carpeta.

Los proyectos se han creado usando gradle en vscode, se ha hecho uso de jacoco para el codecoverage.

## Pregunta 1

### Antes

> El código está tal cual, solo se ha revisado cómo funciona este primer approach
> 

### Fase 1

Pregunta:
Sigue la lógica comercial para un vuelo comercial y traduce eso escribiendo una prueba llamada AirportTest. ¿Cuáles son los resultados de las pruebas con cobertura obtenidas?
¿Puedes indicar algunas conclusiones de lo anterior, necesitamos refactorizar?

> Todos los test pasan, sin embargo, la cobertura es del 57% (con funcion main incluida) pues no se cubren las branchs cuando hay un tipo de vuelo no reconocido. En vez de usar switchs, se puede aplicar polimorfismo
> 

<aside>
💡 Modificación de AirportTest.java para esta fase

</aside>

```java
package Fase1;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AirportTest {

    @DisplayName("Hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger checha;
        private Passenger lore;

        @BeforeEach
        void setUp() {
            economyFlight = new Flight("1", "Economica");
            checha = new Passenger("Checha", false);
            lore = new Passenger("Lore", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(checha)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Checha", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(checha)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(lore)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Lore", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(lore)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }

    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger checha;
        private Passenger lore;

        @BeforeEach
        void setUp() {
            businessFlight = new Flight("2", "Negocios");
            checha = new Passenger("Checha", false);
            lore = new Passenger("Lore", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(checha)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(checha)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puede eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(lore)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(lore)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }
}
```

### Fase 2

Se hizo la refactorización pertinente para lograr que se respete el principio Open/Closed, se siguieron las instrucciones.

> **La refactorización y los cambios de la API se propagan a la implementación de las pruebas. ¿Cómo?**
> 

Sí, las pruebas debieron modificarse para que acepte este nuevo enfoque gracias a la refactorización. Se hace uso del polimorfismo

> **¿Cuál es el código de cobertura ahora? ¿Ayudó la refactorización a la mejor calidad de código?**
> 

Sin contar la clase main (pues no hay test para ella) la cobertura es del 100%, pero con dicha clase, la cobertura total es de 45%

La refactorización ayudó a que el código sea más entendible y a que se respeten los principios SOLID, sin embargo, para respetar el LSP sugiero mover los métodos abstractos a interfaces pues removePassenger solo lo debería implementar EconomyFlight, mas no BusinessFlight.

```java
public class BusinessFlight extends Flight{

    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) { 
            return passengers.add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
```

```java
public class EconomyFlight extends Flight{

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger); 
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) { 
            return passengers.remove(passenger); 
        }
        return false;
    }

}
```

```java
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 

public abstract class Flight { 

    private String id; 
    protected List<Passenger> passengers = new ArrayList<Passenger>(); 

    public Flight(String id) { 
        this.id = id;
    }

    public String getId() { 
        return id; 
    } 

    public List<Passenger> getPassengersList() { 
        return Collections.unmodifiableList(passengers); 
    } 

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger); 
}
```

### Fase 3

Creé la clase PremiumFlight que sigue las directivas dadas.

> **Utiliza la clase AirportTest refactorizada antes de pasar al trabajo para el vuelo premium en el código desarrollado como mejora a tus resultados.**
> 

Con la clase agregada, pero sin modificar el AirportTest, el coverage obtenido es de 40% (incluyendo la clase main). Pero con el AirportTest actualizado se logra un 60% de cobertura junto a la clase main y sin contarla, es de 100%

<aside>
💡 Había avanzado la implementación sin leer la fase 4

</aside>

### Fase 4

Como mencioné antes, esto ya lo hice en la Fase 3, dado que no hice uso de imágenes no puedo corroborar paso a paso que realicé TDD, sin embargo, si no fuese por el TDD hacer esa pregunta hubiese sido complicada de realizar.

```java
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AirportTest {

    @DisplayName("Hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger checha;
        private Passenger lore;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            checha = new Passenger("Checha", false);
            lore = new Passenger("Lore", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(checha)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Checha", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(checha)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(lore)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Lore", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(lore)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }

    @DisplayName("Dado que hay un vuelo de negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger checha;
        private Passenger lore;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            checha = new Passenger("Checha", false);
            lore = new Passenger("Lore", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(checha)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(checha)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puede eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(lore)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(lore)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }

    @DisplayName("Hay un vuelo Premium")
    @Nested
    class PremiumFlightTest{
        private Flight premiumFlight;
        private Passenger checha;
        private Passenger lore;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            checha = new Passenger("Checha", false);
            lore = new Passenger("Lore", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger{
            @Test
            @DisplayName("Entonces no se puede agregar o eliminar de un vuelo premium")
            public void testPremiumFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo Premium", 
                () -> assertEquals(false, premiumFlight.addPassenger(checha)),
                () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(checha)),
                () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo y se puede eliminarlo de un vuelo Premium")
            public void testPremiumFlightVipPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo Premium",
                        () -> assertEquals(true, premiumFlight.addPassenger(lore)),
                        () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(lore)),
                        () -> assertEquals(0, premiumFlight.getPassengersList().size())
                );
            }
        }
    }
}
```

```java
public class PremiumFlight extends Flight{

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        //solo se agrega si es VIP
        if(passenger.isVip())
            return passengers.add(passenger);
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        //se puede remover a los pasajeros
        //Precondicion: todos los pasajeros de este vuelo son VIP
        return passengers.remove(passenger);
    }
    
}
```

### Fase 5

Acá opté por usar un hashmap en vez de un set, porque es mejor al momento de revisar si ya se encuentra dentro o no. Además, que así se puede acceder al objeto, cosa que en un set se tiene que hacer con un bucle for.

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Flight { 

    private String id; 
    protected Map<String, Passenger> passengers = new HashMap<>(); 

    public Flight(String id) { 
        this.id = id;
    }

    public String getId() { 
        return id; 
    } 

    public Map<String, Passenger> getPassengersList() { 
        return Collections.unmodifiableMap(passengers); 
    } 

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger); 
}
```

```java
public class BusinessFlight extends Flight{

    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) { 
            return passengers.putIfAbsent(passenger.getName(),passenger) == null;
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
```

```java
public class EconomyFlight extends Flight{

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.putIfAbsent(passenger.getName(),passenger) == null;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) { 
            return passengers.remove(passenger.getName()) != null;
        }
        return false;
    }

}
```

```java
public class PremiumFlight extends Flight{

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        //solo se agrega si es VIP
        if(passenger.isVip())
            return passengers.putIfAbsent(passenger.getName(),passenger) == null;
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        //se puede remover a los pasajeros
        //Precondicion: todos los pasajeros de este vuelo son VIP
        return passengers.remove(passenger.getName()) != null;
    }
    
}
```

```java
public class Airport { 

    public static void main(String[] args) { 
        Flight economyFlight = new EconomyFlight("1"); 
        Flight businessFlight = new BusinessFlight("2"); 

        Passenger checha = new Passenger("Checha", true); 
        Passenger lore = new Passenger("Lore", false); 

 
        businessFlight.addPassenger(checha); 
        businessFlight.removePassenger(checha); 
        businessFlight.addPassenger(lore); 
        economyFlight.addPassenger(lore); 

        System.out.println(" Lista de pasajeros de vuelos de negocios:"); 
        for (var entry : businessFlight.getPassengersList().entrySet()) { 
            System.out.println(entry.getValue().getName()); 
        } 

        System.out.println(" Lista de pasajeros de vuelos economicos:"); 
        for (var entry : economyFlight.getPassengersList().entrySet()) { 
            System.out.println(entry.getValue().getName()); 
        } 
    } 
}
```