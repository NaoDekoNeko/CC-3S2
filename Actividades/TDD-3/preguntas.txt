 # TDD3 - Pregunta 4
 ### Analiza y explica el código anterior. ¿Se requiere que cambiemos el código de prueba para reflejar ese cambio en la firma del método?. ¿hay algún riesgo en esto?.
El codigo anterior utiliza un assertThat directamente en el metodo de prueba. Mientras que en el otro codigo se 
crea un metodo privado para realizar este assert,en otras palabras tratamos de encapsular la prueba.
