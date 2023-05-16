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
* /
public static List<String> split(String text, char delim, int limit);
```