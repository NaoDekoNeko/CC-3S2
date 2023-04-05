# Principio de segregación de interfaz ( ISP ) SOLID

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
