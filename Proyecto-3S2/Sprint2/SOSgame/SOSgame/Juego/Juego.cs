using System.Reflection.Emit;

namespace SOSgame
{
    public abstract class Juego
    {
        int tamanio;
        public string[,] grid;
        string ganador;
        public Juego(int tamanio)
        {
            this.tamanio = tamanio;
            this.grid = new string[tamanio,tamanio];
        }
    }
}