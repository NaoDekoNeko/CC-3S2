# Principio abierto/cerrado ( OCP ) NO SOLID
### Si entiendes el principio SRP mencionado anteriormente no querrás colocar displayResult() y
### evaluateDistinction() en la misma clase.
## Pregunta: ¿Por qué?.
Porque estas 2 funciones cumplen responsabilidades diferentes.Y si en caso uno
quisiera modificar cualquiera de esas funciones estariamos afectando a la clase
Student.
