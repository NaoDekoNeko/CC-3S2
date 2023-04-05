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

Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.
Probar todas las entradas posibles es la mejor solución a este problema.
El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente.
La verificación de tipos estáticos podría haber detectado este error.
