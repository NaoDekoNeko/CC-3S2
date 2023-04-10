Historias de usuarios y criterios de aceptación
# 1 . ¿Cuáles de las siguientes no son buenas historias? ¿Por qué?

- El usuario puede ejecutar el sistema en Windows XP y Linux.
```
Sí, menciona rol y función
```
- Todos los gráficos y tablas se realizan utilizando una biblioteca de terceros.
```
No, a los usuarios no les importa cómo se implementan
```
- El usuario puede deshacer hasta cincuenta comandos.
```
Sí es pues tiene el esquema: rol, objetivo, beneficio
```
- El software se lanzará el 30 de junio.
```
No, pues se debe definir durante la planificación.
```
- El software estará escrito en Java.
```
No, pues se debe definir durante la planificación. Pero depende del producto, si fuese una librería de clase con nicho específico.
```
- El usuario puede seleccionar su país de una lista desplegable.
```
Si, pues podría ayudarnos a personalizar la experiencia de usuario
```
- El sistema utilizará Log4J para registrar todos los mensajes de error en un archivo.
```
No, contiene información irrelevante para el usuario
```
- Se le pedirá al usuario que guarde su trabajo si no lo ha guardado durante 15 minutos.
```
Sí es pues tiene el esquema: rol, objetivo, beneficio
```
- El usuario puede seleccionar la función "Exportar a XML".
```
Sí, pues ayuda al usuario al lograr algo
```
- El usuario puede exportar datos a XML
```
Sí, tiene una función que beneficia al usuario
```
# 2 . ¿Cuáles de las siguientes no son buenas historias? ¿Por qué?

- Un usuario puede dominar rápidamente el sistema.
```
No, pues rápidamente es un término subjetivo no medible.
```
- Un usuario puede editar la dirección en un currículum.
```
Sí, aunque es una historia algo pequeña
```
- Un usuario puede agregar, editar y eliminar múltiples currículos.
```
Sí, pero se puede dividir la historia en otras más simples.
```
- El sistema puede calcular aproximaciones de puntos de silla para distribuciones de formas cuadráticas en variables normales.
```
No, porque puede ser inentendible, se debe conversar sobre la historia de usuario para que todos entiendan
```
- Todos los errores de tiempo de ejecución se registran de manera coherente.
```
Sí, pues tiene sentido.
```

# 4 . ¿Cuáles pueden ser dos inconvenientes de usar historias de usuario?
En proyectos grandes se pueden tener problemas al manejar las historias de usuario. ie: muchas historias específicas que tienen que ser conversadas para que ambas partes las entiendan, se pierde tiempo.

# 5 . ¿Cómo debes manejar un requisito para que un sistema escale y lo usen 1000 usuarios simultáneos?
Incrementando el numero de usuarios, empezando por ejemplo, probando 5 usuarios, luego 10, y así hasta alcanzar los 1000. Pero no es óptimo.

# 7. Falta responder
### Imaginemos que tu y un amigo tienen una web de Pet Store y, durante este mes, presentan un 10% de descuento en la suscripción Premium. Entonces, cada vez que un usuario de una cuenta gratuita inicia sesión, se le muestra un mensaje que dice:
```
 ¡Suscríbete a Premium ahora con un 10 % de descuento!

```
### En este punto y técnicamente hablando, queremos crear un punto final desde donde podamos obtener un descuento de suscripción para un usuario determinado.