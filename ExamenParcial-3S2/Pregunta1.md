# Pregunta 1

## ¿Cómo está ordenado el código?
Está dividida en dos carpetas:
### NOLSP
Que muestra el código antes de la refactorización
### SLP
Posterior a la refactorización.

## Respuesta
Como vimos se viola el principio LSP, en la clase Free Member.

Para refactorizar, se crean dos interfaces:

### IEveryone
Que va a contener los métodos que todos los miembros pueden hacer uso. En este caso, unirse a un torneo.
### IPremium
Que contiene unicamente los métodos que los usuarios premium pueden realizar. En este caso, es organizar un torneo.

Y se eliminan los métodos abstractos de la clase abstracta Member. 

Luego de esto, se implementan las interfaces de la siguiente forma:

Para Member se implementa la interfaz IEveryone. Pues todos los miembros pueden unirse a un torneo.
#### Como comentario, esta interfaz podría volverse un método abstracto de la clase Member.

Mientras que para PremiumMember, se implementa además la interfaz IPremium.
