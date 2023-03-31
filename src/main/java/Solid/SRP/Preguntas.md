# Principio de responsabilidad única ( SRP )
### Pregunta: Realiza una demostración completa que sigue a SRP. Explica los resultados.
Dentro de la clase Empleado, el metodo displayEmpDetail() tiene la tarea de mostrar los datos
del objeto empleado pertinentes a la misma.
En la clase GeneradorIDEmpleado, el método que comparte nombre con la clase, se encarga de generar el ID del empleado.
Por último, la clase SeniorityChecker, contiene un método que se encarga de comprobar la permanencia de un empleado en la empresa.
Y como cada una de estas clases se enfoca en una unica responsabilidad en particular.
Dividirlo de esa manera cumple con el uso del Principio de Responsabilidad
Unica. (SRP)
