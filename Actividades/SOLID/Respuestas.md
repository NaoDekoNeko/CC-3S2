# Respuestas de los principíos SOLID
##### Solo se copiaron las respuestas de las carpetas individuales en este documento para que estén en un solo lugar (anteriormente estaban en achivos Preguntas.md dentro de la carpeta src/main/java/"SOLID o NO SOLID"/"Nombre del Principio")
# Principio de responsabilidad única ( SRP ) 
## NO SOLID
### Pregunta: Realiza una salida de muestra. Ten en cuenta que la identificación(ID) de un empleado puede variar
en tu caso porque genera un número aleatorio para obtener la identificación (ID) del empleado.
```
Demostracion sin SRP
Nombre del empleado: Abejita,Jessica
Este empleado tiene 7.5 años de experiencia.
El ID del empleado es: J848
Este empleado es un empleado senior
*******
Nombre del empleado: Smart,Chalito
Este empleado tiene 3.2 años de experiencia.
El ID del empleado es: C771
Este empleado es un empleado junior
```

### Pregunta: ¿Cuál es el problema con este diseño?

  El problema es que la clase empleado tiene 3 responsabilidades, estas no están relacionadas una con otra para cumplir
  con un objetivo o responsabilidad.  
  Eg: checkSeniority() y empID(), sus funciones difieren.
  Lo que debería suceder es que la clase tenga cohesión, es decir,
  que sus métodos estén estrechamente relacionados para cumplir una determinada tarea (responsabilidad).

## SOLID
### Pregunta: Realiza una demostración completa que sigue a SRP. Explica los resultados.
Dentro de la clase Empleado, el metodo displayEmpDetail() tiene la tarea de mostrar los datos
del objeto empleado pertinentes a la misma.
En la clase GeneradorIDEmpleado, el método que comparte nombre con la clase, se encarga de generar el ID del empleado.
Por último, la clase SeniorityChecker, contiene un método que se encarga de comprobar la permanencia de un empleado en la empresa.
Y como cada una de estas clases se enfoca en una unica responsabilidad en particular.
Dividirlo de esa manera cumple con el uso del Principio de Responsabilidad
Unica. (SRP)
# Principio abierto/cerrado ( OCP )
##  NO SOLID
### Si entiendes el principio SRP mencionado anteriormente no querrás colocar displayResult() y evaluateDistinction() en la misma clase.
## Pregunta: ¿Por qué?.
Porque estas 2 funciones cumplen responsabilidades diferentes.Y si en caso uno
quisiera modificar cualquiera de esas funciones estariamos afectando a la clase
Student. Si alguna de estas dos funciones necesita ser modificada, entonces es posible que debamos modificar la clase Student en su totalidad, incluso si los otros métodos no necesitan ser modificados. 

## SOLID
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

# Principio de Sustitución de Liskov ( LSP )
## NO SOLID
### Pregunta: Realiza una salida de muestra y describe la excepción resultante. ¿Cuál es el problema?.
Salida :
```
	*Exception in thread "main" java.lang.UnsupportedOperationException
	at NoSolid.LSP.GuestUserPayment.previousPaymentInfo(GuestUserPayment.java:10)
	at NoSolid.LSP.PaymentHelper.showPreviousPayments(PaymentHelper.java:14)
	at NoSolid.LSP.Cliente.main(Cliente.java:21)*
```
  
La excepción lanzada hace referencia a una operación **no soportada**, y hace que
se rompa el ciclo, haciendo que no avance al nuevo pago.
El problema es que el usuario invitado no posee un registro de sus pagos
anteriores, pero al implementar la misma interfaz que un usuario registrado,
que sí posee dicha información, se lanza la excepción.

## SOLID

### Problema: ¿cuáles son los cambios clave?. Explica tus resultados.

    Un cambio clave ha sido la liberación del metodo previousPayments de los objetos de la clase
    guestUser, pues no solo no tienen registro de pagos anteriores, sino que no pueden tenerlos,
    su clase no contempla la creación de dicho registro.
    Estos cambios permiten una mejor separación de responsabilidades y una mayor cohesión en el código.
    Ahora, cada interfaz se encarga de una tarea específica y las clases implementan solo las interfaces
    necesarias para su funcionalidad.


# Principio de segregación de interfaz ( ISP ) 
## NO SOLID
### Pregunta: En este caso ISP sugiere que diseñes tu interfaz con los métodos adecuados que un cliente en particular pueda necesitar. ¿Por qué un usuario necesita cambiar una clase base (o una interfaz)?

    Porque no cumple con todas sus necesidades, ya sea que implementa métodos
    que no necesita o se ve en la necesidad de implementar nuevos métodos para
    que las satisfaga.


  ### Pregunta: ¿Ayuda escribir código polimórfico como el siguiente?.
```java
    Impresora impresora = new ImpresoraAvanzada();
    impresora.printDocument();
    impresora.sendFax();
    impresora = new ImpresoraBasica();
    impresora.printDocument();
    // impresora.sendFax();
```
   **Explica tu respuesta.**
    
    Si ayuda pues así dejamos en evidencia que el método sendfax() no es usada 
    por todas las clases hija de impresora,porque cada objeto de subclase implementa
    solo los métodos que necesita, sin tener que implementar métodos innecesarios.

### Pregunta: ¿Qué sucede si escribimos algo así en el código dado?
```java
    List<Impresora> impresoras = new ArrayList<Impresoras>();
    impresoras.add(new ImpresoraAvanzada());
    impresoras.add(new ImpresoraBasica());
    for (Impresora device : impresoras) {
        device.printDocument();
    // device.sendFax();
    }
 ```
    Cada impresora ejecuta el método printDocument(), pero al retirar comentario,
    nos lanza una excepción pues la impresora básica no soporta el método sendFax()
## SOLID

### Pregunta - SOLID : Realiza una salida de muestra

    Demostracion ISP
    La impresora basica imprime un documento.
    La impresora avanzada imprime un documento.
    La impresora avanzada envia un fax.

### Pregunta:¿Qué sucede si usas un método predeterminado dentro de la interfaz?
    Por ejemplo, si proporcionas un método de fax predeterminado en una interfaz (o una clase abstracta),
    ImpresoraBasica debes sobreescribirlo y decir algo similar a lo siguiente:
```java
    @Override
    public void sendFax() {
        throw new UnsupportedOperationException();
    }
```


### Pregunta: ¿Viste el problema potencial con esto? . Pero,¿qué sucede si usas un método vacío, en lugar de lanzar la excepción?.

    Si, el problema es que se esta ejecutando una funcion que la subclase
    ImpresoraBasica no debería realizar, por lo que lanza una excepción,
    la cual rompe el ciclo de ejecución de nuestro programa.

    Si usas un metodo vacio la funcion no va realizar nada pero, ¿estarias
    llamando innecesariamente a una funcion vacia para arreglar esto? .
    Sabemos que la llamada a una funcion añade una unidad de tiempo de
    ejecucion a la complejidad de un algoritmo.

# Principio de inversión de dependencia ( DIP )
## NO SOLID
### Pregunta: Realiza una salida de muestra.¿Cuáles son los problemas que adolece el código?

    La clase InterfazUsuario está fuertemente acoplada a
    la clase OracleDatabase, ya que crea una instancia directamente
    en el constructor. Esto significa que si queremos cambiar
    la base de datos a la que se guarda la identificación del empleado,
    necesitamos cambiar el código en InterfazUsuario.

    La clase InterfazUsuario viola el principio de inversión de
    dependencia (DIP), ya que depende
    de una clase concreta (OracleDatabase) en lugar de una abstracción
    como podría ser una clase BaseDeDatos.
## SOLID
### Pregunta: Realiza una salida de muestra.¿Esto resuelve todos los problemas que adolece el código?.

  Si porque ahora se puede hacer el guardado de datos del usuario
  en la base de datos que se elija, agregando más bases de datos.

### Pregunta: ¿Cuál es el beneficio de hacer esto?.
  El beneficio de hacer esto es que ahora podemos agregar el usuario
  a otra base de datos.InterfazUsuario es ahora independiente de la
  implementación concreta de BaseDatos y puede trabajar con cualquier
  objeto que implemente la interfaz BaseDatos. Esto hace que el código
  sea más flexible y fácil de mantener.

### Pregunta: Verifica tus resultados.
    Demostracion con DIP
    El id : E002 es guardado en la base de datos Oracle
    El id: E002 es guardado en la base de datos MySQL
    El id : E002 es guardado en la base de datos Postgres
