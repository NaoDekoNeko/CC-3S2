using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static ReSOSgame.Tablero;

namespace ReSOSgame
{
    public abstract class Juego
    {
        public Tablero tablero;
        public ScoreValidator validator;
        public Juego(Tablero tablero)
        {
            this.tablero = tablero;
            validator = new ScoreValidator(tablero);
        }
        public abstract void FinalGameState(); // Funcion que indica el estado final del juego

        public abstract bool HayGanador();

        public abstract void Jugar(int row, int col, Cell ficha);
        public abstract bool PuntoHorizontal();
        public abstract bool PuntoVertical();
        public abstract void MakeMove(int row,int col ,Cell ficha); // Funcion para realizar un movimiento
        public abstract bool PuntoDiagIzq();
        public abstract bool PuntoDiagDer();
        public abstract bool TableroLLeno();
        public abstract bool Win(int row1,int col1, Cell ficha);
    }
    public class JuegoSimple : Juego
    {
        public JuegoSimple(Tablero tablero) : base(tablero)
        {
        }
        // Funcion que verifica si se ha ganado el juego simple
        // Funcion que actualiza el estado del juego Simple 
        public override void FinalGameState() 
        {
            if (validator.FullBoard())
            {
                tablero.EstadoDeJuego = Tablero.GameState.EMPATE;
            }
            else
            {
                tablero.EstadoDeJuego = tablero.Turno == Tablero.Jugador.AZUL ?
                    Tablero.GameState.GANOAZUL : Tablero.GameState.GANOROJO;  // Cambia el estado del tablero
            }
        }
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
                tablero.Turno = (tablero.Turno == Jugador.AZUL) ? Jugador.ROJO : Jugador.AZUL;
            }
        }
        

        public override void MakeMove(int row, int column, Cell _ficha)
        {
            if(!validator.GameOver()) // Si es el estado de juego es JUGANDO
            {
                if (row >= 0 && row < tablero.Tamanio && column >= 0 && column < tablero.Tamanio
                       && tablero.GetCell(row, column) == 0)
                {
                    tablero.ValidMove = true;
                    tablero.Ficha = _ficha;
                    tablero.Grid[row, column] = _ficha;
                    if(validator.HasOnePoint(row,column,tablero.Ficha) || validator.FullBoard()) // Cuando se ha hecho ganado 1 punto 
                    {
                        FinalGameState();
                    }
                    if (tablero.EstadoDeJuego == GameState.JUGANDO)
                    {
                        tablero.Turno = (tablero.Turno == Jugador.AZUL) ? Jugador.ROJO : Jugador.AZUL;
                    }
                }
                else
                {
                    tablero.ValidMove = false;
                }
            }
            else
            {
                tablero.ValidMove = false;
            }
        }
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
        public override bool HayGanador()
        {
            return false;
        }

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
    }
    public class JuegoGeneral : Juego
    {
        // Atributos para tener los puntajes de cada jugador
        private int puntajeAzul = 0;
        private int puntajeRojo = 0;
        public JuegoGeneral(Tablero tablero) : base(tablero)
        {
        }
        public int PuntajeAzul { get { return puntajeAzul; } }
        public int PuntajeRojo { get { return puntajeRojo; } }
        // Funcion que verifica si se ha ganado en un Juego General

        public override void FinalGameState() // Calcula el estado final comparando los puntajes
        {

            if (puntajeAzul > puntajeRojo)
            {
                tablero.EstadoDeJuego = Tablero.GameState.GANOAZUL; // Establece que el azul ha ganado
            }
            else if (puntajeAzul < puntajeRojo)
            {
                tablero.EstadoDeJuego = Tablero.GameState.GANOROJO; // Establece que el rojo ha ganado
            }
            else if (puntajeRojo==puntajeAzul)
            {
                tablero.EstadoDeJuego = Tablero.GameState.EMPATE; // Establece que ha habido un empate
            }
            //sino, el estado de juego es JUGANDO
        }

        public override bool HayGanador()
        {
            throw new NotImplementedException();
        }

        public override void Jugar(int row, int col, Cell ficha)
        {
            throw new Exception();
        }

        public override void MakeMove(int row, int column, Cell _ficha)
        {
            if(!validator.GameOver())
            {
                if (row >= 0 && row < tablero.Tamanio && column >= 0 && column < tablero.Tamanio
                       && tablero.Grid[row, column] == 0)
                {
                    tablero.ValidMove = true;
                    tablero.Ficha = _ficha;
                    tablero.Grid[row, column] = _ficha;
                    if (validator.HasOnePoint(row, column, tablero.Ficha)) // Si se ha obtenido un punto
                    {
                        //en el turno del jugador AZUL
                        if (tablero.Turno == Jugador.AZUL)
                        {
                            puntajeAzul++; // Se agrega un punto al jugador Azul
                        } //en el turno del jugador ROJO
                        else                        {
                            puntajeRojo++; // Se agrega un punto al jugador Rojo
                        }
                    }
                    if (validator.FullBoard())
                    {
                        FinalGameState(); // Actualiza el estado del juego cuando el tablero esta lleno
                    }
                    // Nota: esa funcion detiene el cambio de turno cuando ya se halla ganado o empatado
                    if (tablero.EstadoDeJuego == GameState.JUGANDO) // Si se sigue jugando
                    {
                        tablero.Turno = (tablero.Turno == Jugador.AZUL) ? Jugador.ROJO : Jugador.AZUL; // Se cambia de turno al jugador contrario
                    }
                }
            }
            else
            {
                tablero.ValidMove = false;
            }
        }

        public override bool PuntoDiagDer()
        {
            throw new NotImplementedException();
        }

        public override bool PuntoDiagIzq()
        {
            throw new NotImplementedException();
        }

        public override bool PuntoHorizontal()
        {
            throw new NotImplementedException();
        }

        public override bool PuntoVertical()
        {
            throw new NotImplementedException();
        }

        public override bool TableroLLeno()
        {
            throw new NotImplementedException();
        }

        public override bool Win(int row1, int col1, Cell ficha)
        {
            throw new NotImplementedException();
        }
    }
}