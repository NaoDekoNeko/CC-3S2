package com.sales.domain;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SalesReportTest {

    private static final int NUMBER_OF_SALES = 5;
    private static final LocalDate start = LocalDate.of(2023,5,10);
    private static final LocalDate end = LocalDate.of(2023,6,18);

    @Mock
    SalesRepository salesRepository;
    
    @Mock
    List<Sale> previousSales;

    @Test
    void countPreviousSales(){
        //Cuenta cuantas ventas hubo en un rango de fechas
        when(salesRepository.allWithinDateRange(any(), any())).thenReturn(previousSales);
        when(previousSales.size()).thenReturn(NUMBER_OF_SALES);
        var prevSales = salesRepository.allWithinDateRange(start, end);
        var salesCount = prevSales.size();
        assertThat(salesCount).isEqualTo(NUMBER_OF_SALES);
    }
}

/*
 * Date cuenta que lo importante de la arquitectura hexagonal no es el código que hace posible la interacción entre
 * la base de datos y la aplicación. Sino que se encarga de que la comunicación sea entendible para ambas partes:
 * no importa cómo viajan los datos ni cómo se procesan (en el adaptador), sino que cómo estos datos van a comunicarse con nuestra 
 * interfaz (puerto).
 */
