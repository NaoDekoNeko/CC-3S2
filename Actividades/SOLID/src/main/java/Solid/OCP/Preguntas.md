# Principio abierto/cerrado ( OCP )
## Pregunta: Realiza una salida de muestra de tu respuesta. Explica los cambios realizados
El programa es flexible porque a partir de la clase estudiante se extienden nuevas subclases
para el departamento especifico al que pertence el estudiante, y a su vez estas subclases
implementan la interfaz DistinctionDecider.
 Esto genera que no tengamos que modificar la funcion evaluatedistinction para un conjunto
 determinado de clases. Sino que se crean dos nuevos metodos en las subclases  para
 calcular la distincion  en funcion de las puntuaciones de cada departamento.
## Pregunta: ¿Cuáles son las principales ventajas ahora?
Se puede agregar nuevas funcionalidades sin tener que modificar el codigo existente.
En este caso se pueden crear nuevas subclases para los departamentos que se quieran añadir,
o también eliminar departamentos sin afectar a la clase principal.
