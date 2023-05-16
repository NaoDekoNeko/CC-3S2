# Pregunta 3

Por falta de tiempo, pues ordenar es más tedioso de lo que pensaba ;-;
solo haré las pruebas del juego simple. Y en vez de hacer el RGR caso por caso, juntaré los que crea convenientes. 

El código es muy similar al RGR del TicTacToe de la pregunta 2, por lo que reciclaré mucho de ahí. Si bien no es una manera muy self explanatory, agregaré las acotaciones y comentarios para que pueda ser lo más entendible posible.

Estoy tomando de base el Sprint 3 de nuestro proyecto

## Requisito 1: Límites del tablero

### X e Y fuera del tablero

Método vacío

![Untitled](./Imagenes/Pregunta%203/Untitled.png)

Implemento el método:

```C#
public override void Jugar(int row, int col)
{
throw new Exception();
}
```

tanto en la clase JuegoSimple, como en la clase JuegoGeneral

Corro los test:

![Untitled](./Imagenes/Pregunta%203/Untitled%201.png)

Modifico el código:

```C#
public override void Jugar(int row, int col)
        {
            if (row < 1 || row > tablero.Tamanio || col < 1 || col > tablero.Tamanio)
            {
                throw new Exception();
            }
        }
```

Test otra vez

![Untitled](./Imagenes/Pregunta%203/Untitled%202.png)

### Casilla ocupada

Se ha modificado el método para que se necesite ingresar S u O como parámetro, mas no el funcionamiento interno

```C#
public override void Jugar(int row, int col, Cell ficha)
        {
            if (row < 1 || row > tablero.Tamanio || col < 1 || col > tablero.Tamanio)
            {
                throw new Exception();
            }
        }
```

![Untitled](./Imagenes/Pregunta%203/Untitled%203.png)

Modificamos el método

```C#
public override void Jugar(int row, int col, Cell ficha)
        {
            if (row < 1 || row > tablero.Tamanio || col < 1 || col > tablero.Tamanio)
            {
                throw new Exception();
            }
            else if (tablero.Grid[row - 1,col - 1] == Cell.VACIA)
            {
                tablero.Grid[row - 1, col - 1] = ficha;
            }
        }
```

Y dentro de tablero se ha modificado el método GetCell

```C#
public Cell GetCell(int row , int column)
        {
            int rowAux = row - 1;
            int colAux = column - 1;
            if (rowAux >= 0 && colAux >= 0 && rowAux < tamanio && colAux < tamanio)
                return grid[rowAux, colAux];
            else
                return Cell.INVALIDA;
        }
```

Con estos cambios, el test pasa

![Untitled](./Imagenes/Pregunta%203/Untitled%204.png)

### Refactorización

Separando los métodos:

```C#
private void ComprobarMov(int row, int col)
        {
            if (row < 1 || row > tablero.Tamanio || col < 1 || col > tablero.Tamanio)
            {
                throw new Exception();
            }
        }
public override void Jugar(int row, int col, Cell ficha)
        {
            ComprobarMov(row,col);
            if (tablero.Grid[row - 1,col - 1] == Cell.VACIA)
            {
                tablero.Grid[row - 1, col - 1] = ficha;
            }
        }
```

Las pruebas siguen pasando con esta refactorización:

![Untitled](./Imagenes/Pregunta%203/Untitled%205.png)

## Requisito 2: Agregar soporte para dos jugadores

### Azul juega primero

Se va a esperar que el primer movimiento lo haga el AZUL, pero la propiedad siempre devolverá ROJO, por lo que va a fallar. (Dentro de la clase Tablero)

```C#
public Jugador Turno { get { return Jugador.ROJO; }
            set { turno = value; }}
```

![Untitled](./Imagenes/Pregunta%203/Untitled%206.png)

Arreglando la property para que devuelva el turno:

```C#
public Jugador Turno { get { return turno; }
            set { turno = value; }}
```

Y haciendo que, al iniciar el tablero se asigne el primer turno al AZUL:

```C#
public void InitBoard()
        {
            for(int row = 0; row < tamanio; row++)
            {
                for(int column = 0; column < tamanio; column++)
                {
                    grid[row, column] = Cell.VACIA;
                }
            }
            turno = Jugador.AZUL;
        }
```

El test pasa

![Untitled](./Imagenes/Pregunta%203/Untitled%207.png)

### Rojo juega inmediatamente después de Azul

Falla porque no hay cambio de turno

![Untitled](./Imagenes/Pregunta%203/Untitled%208.png)

Implementamos el cambio de turno dentro del método Jugar

```C#
public override void Jugar(int row, int col, Cell ficha)
        {
            ComprobarMov(row,col);
            if (tablero.Grid[row - 1,col - 1] == Cell.VACIA)
            {
                tablero.Grid[row - 1, col - 1] = ficha;
                tablero.Turno = (tablero.Turno == Jugador.AZUL) ? Jugador.ROJO : Jugador.AZUL;
            }
        }
```

Ahora pasa el test

![Untitled](./Imagenes/Pregunta%203/Untitled%209.png)

## Requisito 3: Ganadores

### No hay ganador

Implementamos:

```C#
public override bool HayGanador()
        {
           return true;
        }
```

Falla pues regresa que sí hay ganador

![Untitled](./Imagenes/Pregunta%203/Untitled%2010.png)

Cambiando true por false, hacemos que la prueba pase

![Untitled](./Imagenes/Pregunta%203/Untitled%2011.png)

### Ganador horizontal

Falla

![Untitled](./Imagenes/Pregunta%203/Untitled%2012.png)

Implementamos el método

```C#
public override bool PuntoHorizontal()
        {
            for (int i = 0; i < tablero.Tamanio; i++)
            {
                //se fija si la primer ficha de la fila tiene coincidencia en toda la fila
                if (tablero.Grid[0,i] == Cell.S &&
                        tablero.Grid[0,i+1] == Cell.O &&
                        tablero.Grid[0, i+2] == tablero.Grid[0, i])
                {
                    return true;
                }
            }
            return false;
        }
```

Y ahora el test pasa

![Untitled](./Imagenes/Pregunta%203/Untitled%2013.png)

### Ganador Vertical

![Untitled](./Imagenes/Pregunta%203/Untitled%2014.png)

Implementamos el método

```C#
public override bool PuntoVertical()
        {
            for (int i = 0; i < tablero.Tamanio; i++)
            {
                //se fija si la primer ficha de la fila tiene coincidencia en toda la fila
                if (tablero.Grid[i, 0] == Cell.S &&
                        tablero.Grid[i+1, 0] == Cell.O &&
                        tablero.Grid[i + 2, 0] == tablero.Grid[i, 0])
                {
                    return true;
                }
            }
            return false;
        }
```

Ahora el test pasa :D

![Untitled](./Imagenes/Pregunta%203/Untitled%2015.png)

### Ganador Diagonal

Implementaré código con bucles desde un inicio

Falla en ambas diagonales

![Untitled](./Imagenes/Pregunta%203/Untitled%2016.png)

Implementamos los métodos:

```C#
public override bool PuntoDiagIzq()
        {
            for (int i = 0; i < tablero.Tamanio-2; i++)
            {
                if ( tablero.Grid[i,i] == Cell.S &&
                    tablero.Grid[i+1,i+1] == Cell.O &&
                    tablero.Grid[i+2, i+2] == Cell.S)
                {
                    return true;
                }
            }
            return false;
        }

        public override bool PuntoDiagDer()
        {
            for (int i = 0; i < tablero.Tamanio - 2; i++)
            {
                if (tablero.Grid[i, tablero.Tamanio - i - 1] == Cell.S &&
                    tablero.Grid[i + 1, tablero.Tamanio - i - 2] == Cell.O &&
                    tablero.Grid[i + 2, tablero.Tamanio - i - 3] == Cell.S)
                {
                    return true;
                }
            }
            return false;
        }
```

Pasa los test

![Untitled](./Imagenes/Pregunta%203/Untitled%2017.png)

## Requisito 4: Empate

### Empate simple

![Untitled](./Imagenes/Pregunta%203/Untitled%2018.png)

Implementamos el método:

```C#
public override bool TableroLLeno()
        {
            for (int i = 0; i < tablero.Tamanio; i++)
            {
                for (int j = 0; j < tablero.Tamanio; j++)
                {
                    if (tablero.Grid[i,j] == Cell.VACIA)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
```

Ahora los test pasan

![Untitled](./Imagenes/Pregunta%203/Untitled%2019.png)

### Refactorización

![Untitled](./Imagenes/Pregunta%203/Untitled%2020.png)

Implementar el método:

```C#
public override bool Win(int row, int col, Cell ficha)
        {
            if (ficha == Cell.S)
            {
                return (tablero.GetCell(row + 1, col + 1) == Cell.O && tablero.GetCell(row + 2, col + 2) == Cell.S) ||
                    (tablero.GetCell(row - 1, col - 1) == Cell.O && tablero.GetCell(row - 2, col - 2) == Cell.S) ||
                    (tablero.GetCell(row, col + 1) == Cell.O && tablero.GetCell(row, col + 2) == Cell.S) ||
                    (tablero.GetCell(row, col - 1) == Cell.O && tablero.GetCell(row, col - 2) == Cell.S) ||
                    (tablero.GetCell(row + 1, col) == Cell.O && tablero.GetCell(row + 2, col) == Cell.S) ||
                    (tablero.GetCell(row - 1, col) == Cell.O && tablero.GetCell(row - 2, col) == Cell.S);
            }
            return (tablero.GetCell(row - 1, col - 1) == Cell.S && tablero.GetCell(row + 1, col + 1) == Cell.S) ||
                    (tablero.GetCell(row + 1, col - 1) == Cell.S && tablero.GetCell(row - 1, col + 1) == Cell.S) ||
                    (tablero.GetCell(row - 1, col) == Cell.S && tablero.GetCell(row + 1, col) == Cell.S) ||
                    (tablero.GetCell(row, col - 1) == Cell.S && tablero.GetCell(row, col + 1) == Cell.S);
        }
```

Finalmente, todos los test pasan

![Untitled](./Imagenes/Pregunta%203/Untitled%2021.png)

### Comentario:
 Aún no sé dónde falla que no da el punto en la diagonal derecha de esta forma
 ## Coverage
 Los porcentajes eran los esperables dado que no utilice score validator y en vez de usar los métodos existentes de la clase juego, se crearon nuevos
 ![Coverage](./Imagenes/Pregunta%203/Coverage.png)