# Pruebas en sotware - parte1
## Ejercicio 1

### Abejita, quien escribió este método y cree que debería funcionar, lo prueba en un par de casos de prueba elegidos al azar que se muestran a continuación. ¿Cuál es el resultado de cada caso de prueba?
- andAll([true, true, true, ..., true, true]) // 32 valores true

El resultado del primer caso de prueba sería true, ya que todos los valores en el arreglo son true.

- andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true 

El resultado del segundo caso de prueba sería false, ya que no todos los valores en el arreglo son true.

- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error?

El error off-by-one en el código es que el ciclo for en el método andAll solo itera hasta i < 31, en lugar de i < bits.length. Esto significa que el último valor en el arreglo no se comprueba, lo que podría dar lugar a un resultado incorrecto.

- ¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?

Para probar esta función exhaustivamente, se necesitaría un número de casos de prueba igual a 2^n, donde n es el número de elementos en el arreglo. En este caso, como el arreglo tiene 32 elementos, se necesitarían 2^32 casos de prueba. Debido a que este número es extremadamente grande, no es práctico probar la función exhaustivamente. En su lugar, se pueden elegir algunos casos de prueba representativos para asegurarse de que la función funcione correctamente.

## Ejercicio 2
En la década de 1990, el vehículo de lanzamiento Ariane 5, diseñado y construido para la Agencia Espacial Europea, se autodestruyó 37 segundos después de su primer lanzamiento. El motivo fue un error del software de control que no se detectó. El software de guía del Ariane 5 se reutilizó del Ariane 4, que era un cohete más lento. Cuando el cálculo de la velocidad se convirtió de un número de coma flotante de 64 bits (el mismo que un número en TypeScript, aunque este software no se escribió en TypeScript) a un número entero con signo de 16 bits, desbordó el número entero pequeño y provocó una excepción. El controlador de excepciones se había deshabilitado por razones de eficiencia, por lo que el software de guía se bloqueó. Sin guía, el cohete también se estrelló. El costo de la falla fue de mil millones de dólares.

### ¿Qué ideas demuestra esta historia?

Esta historia demuestra varias ideas importantes:

- Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales. Aunque el software de guía del Ariane 5 fue diseñado y construido con los más altos estándares de calidad y seguridad, un error en el cálculo de la velocidad que no se detectó causó la falla catastrófica del cohete.
- La prueba exhaustiva de todas las entradas posibles no siempre es la mejor solución. En este caso, sería impracticable probar todas las entradas posibles debido al gran número de entradas que podría haber. En cambio, se deben tomar medidas adicionales para garantizar que el software sea robusto y pueda manejar entradas inesperadas.
- El software puede exhibir un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente. A diferencia de los sistemas físicos que tienen un comportamiento continuo y predecible, el software puede comportarse de manera discontinua, lo que significa que un pequeño error en la entrada o el procesamiento puede tener un gran impacto en la salida.
- La verificación de tipos estáticos podría haber detectado este error. Si el software hubiera sido escrito en un lenguaje de programación que proporciona verificación de tipos estáticos, como TypeScript, el error podría haber sido detectado antes de que se produjera la falla del cohete. La verificación de tipos estáticos puede ayudar a prevenir errores comunes en el software y aumentar su seguridad y confiabilidad.

# Pruebas sistemáticas
## Ejercicio 3
Un conjunto de pruebas es correcto si:
- Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal
## Ejercicio 4
Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es:
- Correcto

# Elección de casos de prueba mediante partición
### Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:
```java
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

### Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.
```
// particion: x < 0; x >= 0
```
- Los subdominios son disjuntos: SI
- Los subdominios están completos: SI
- Los subdominios son correctos: NO, pues también toma en cuenta los double o float
