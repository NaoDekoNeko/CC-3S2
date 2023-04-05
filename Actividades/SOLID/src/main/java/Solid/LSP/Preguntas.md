# Principio de Sustitución de Liskov ( LSP ) SOLID

### Problema: ¿cuáles son los cambios clave?. Explica tus resultados.

    Un cambio clave ha sido la liberación del metodo previousPayments de los objetos de la clase
    guestUser, pues no solo no tienen registro de pagos anteriores, sino que no pueden tenerlos,
    su clase no contempla la creación de dicho registro.
    Estos cambios permiten una mejor separación de responsabilidades y una mayor cohesión en el código.
    Ahora, cada interfaz se encarga de una tarea específica y las clases implementan solo las interfaces
    necesarias para su funcionalidad.
