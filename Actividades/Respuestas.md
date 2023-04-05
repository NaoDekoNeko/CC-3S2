#Ejercicio 1
##Abejita, quien escribió este método y cree que debería funcionar, lo prueba en un par de casos de prueba elegidos al azar que se muestran a continuación. ¿Cuál es el resultado de cada caso de prueba?
>andAll([true, true, true, ..., true, true]) // 32 valores true
El resultado del primer caso de prueba sería true, ya que todos los valores en el arreglo son true.
>andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true 
El resultado del segundo caso de prueba sería false, ya que no todos los valores en el arreglo son true.
>Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error?
El error off-by-one en el código es que el ciclo for en el método andAll solo itera hasta i < 31, en lugar de i < bits.length. Esto significa que el último valor en el arreglo no se comprueba, lo que podría dar lugar a un resultado incorrecto.
>¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?
Para probar esta función exhaustivamente, se necesitaría un número de casos de prueba igual a 2^n, donde n es el número de elementos en el arreglo. En este caso, como el arreglo tiene 32 elementos, se necesitarían 2^32 casos de prueba. Debido a que este número es extremadamente grande, no es práctico probar la función exhaustivamente. En su lugar, se pueden elegir algunos casos de prueba representativos para asegurarse de que la función funcione correctamente.
#Ejercicio 2
