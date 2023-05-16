# Pregunta 4
## a. ¿Qué son las pruebas efectivas y sistemáticas?
Las pruebas efectivas y sistemáticas son un enfoque estructurado y metódico para crear casos de prueba y desarrollar un conjunto de pruebas sólido y completo. 

Para crear estos casos de prueba se deben seguir pasos sistemáticos. Comienza analizando los requisitos del programa o método bajo prueba y desglosándolos en entradas y salidas esperadas. Se exploran diferentes combinaciones de entradas y salidas para crear casos de prueba significativos. 

Existen técnicas como la prueba de estructura y la cobertura de código completan el conjunto de pruebas.
## b.Pruebas
```Java
/**
* Dividir una cadena en un carácter delimitador.
*
* @param texto una cadena
* @param delimitador un delimitador por el cual dividir la cadena
* @param límite un límite superior en el número de elementos a devolver:
si límite < 0, no hay límite superior; límite != 0
* @retorna una lista de cadenas [s1, s2, ..., sN] tales que:
* - texto = s1 + delimitación + s2 + delimitación + ... + delimitación + sN
* - N <= límite si límite > 0
* - none de s1, s2, ..., sN contiene delimitador
* @throws IllegalArgumentException si límite > 0
*
* y hay más de limite-1 ocurrencias de delimitador en el texto.
*/
public static List<String> split(String text, char delim, int limit);
```
### a.Comienza a implementar una estrategia de prueba sistemática para esta función escribiendo una buena partición del espacio de entrada solo en el límite de entrada, es decir, la partición no debe mencionar ni el texto ni el delimitador.

### Para el parámetro limit
- Tenemos los casos de límite negativo. ie: limit<0
  - Consideremos el caso limit = -1. Como no tiene límite superior, entonces devuelve todas los elementos divididos por el especificador.
  - Pero también sirve para limit = -200, que escogí de forma arbitraria, por lo mismo que no hay límite superior. 
- Cuando el límite es 0. ie: limit = 0. 
  - La función no debería dividir la cadena además, debe devolver una lista con el texto completo.
  - Para limit>0 y hay más de limit-1 ocurrencias. Arroja una excepcion de tipo IllegalArgumentException. Esto sucederá con todas los límites > 0 si seguimos la especificación

### b.Ahora, escriba una buena partición del espacio de entrada sobre la relación entre el límite y las ocurrencias del delimitador en el texto. Tu partición debe mencionar las tres entradas.

- Caso lim<0
  - limit = -1
    - Entrada: text = "Ayuda.Quiero.Dormir", delim = '.', limit = -1
    - Salida esperada: ["Ayuda","Quiero","Dormir"]
  - limit = -200
    - Entrada: text = "Ayuda.Quiero.Dormir.Por.Favor", delim = '.', limit = -200
    - Salida esperada: ["Ayuda","Quiero","Dormir","Por","Favor"]
- Caso limit = 0
    - Entrada text = "no se va a dividir", delim = '.', limit = 0
    - Salida esperada: ["no se va a dividir"]
- Caso limit > 0
    - limit = 1
      - Entrada text = "no, se, va, a, dividir", delim = ',', limit = 1
      - - Salida esperada: Exception de tipo IllegalArgumentException pues hay más de `limit-1 = 0` ocurrencias del delimitador ','
    - limit = 2
      - Entrada text = "no, se, va, a, dividir", delim = ',', limit = 2
      - Salida esperada: Exception de tipo IllegalArgumentException pues hay más de `limit-1 = 2` ocurrencias del delimitador ','
    - limit = 7
      - Entrada text = "I.Hope.That.We.Meet.In.Another.Life.Rawr", delim = '.', limit = 7
      - Salida esperada: - Salida esperada: Exception de tipo IllegalArgumentException pues hay más de `limit-1 = 6` ocurrencias del delimitador '.'

Como se pudo ver, el @throws está muy mal implementado, habría que corregir lo que sucede cuando haya `limite-1` ocurrencias para solucionarlo