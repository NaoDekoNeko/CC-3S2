
# Principio de segregación de interfaz ( ISP ) NO SOLID
  ### Pregunta: En este caso ISP sugiere que diseñes tu interfaz con los métodos adecuados que un cliente en particular pueda necesitar. ¿Por qué un usuario necesita cambiar una clase base (o una interfaz)?

    Porque no cumple con todas sus necesidades, ya sea que implementa métodos que no necesita o se ve en la necesidad
    de implementar nuevos métodos para que las satisfaga.


  ### Pregunta: ¿Ayuda escribir código polimórfico como el siguiente?.
    ´´´java
    Impresora impresora = new ImpresoraAvanzada();
    impresora.printDocument();
    impresora.sendFax();
    impresora = new ImpresoraBasica();
    impresora.printDocument();
    // impresora.sendFax();
    ´´´
   **Explica tu respuesta.**
    
    Si ayuda pues así dejamos en evidencia que el método sendfax() no es usada por todas las clases hija de impresora,
    porque cada objeto de subclase implementa solo los métodos que necesita, sin tener que implementar métodos innecesarios.

   ### Pregunta: ¿Qué sucede si escribimos algo así en el código dado?
     ´´´java
    List<Impresora> impresoras = new ArrayList<Impresoras>();
    impresoras.add(new ImpresoraAvanzada());
    impresoras.add(new ImpresoraBasica());
    for (Impresora device : impresoras) {
        device.printDocument();
    // device.sendFax();
    }
    ´´´
    Cada impresora ejecuta el método printDocument(), pero al retirar comentario, nos lanza una excepción pues
    la impresora básica no soporta el método sendFax()
