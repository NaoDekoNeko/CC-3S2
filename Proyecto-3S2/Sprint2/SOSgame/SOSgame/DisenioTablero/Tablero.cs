using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SOSgame.Tablero
{
    // Clase para cambiar el Tablero o inicializarlo
    public class CreacionTablero
    {
        // Funcion que cambia el tamaño del tablero
        public void CambiarTablero(int tamanio,TableLayoutPanel panel)
        {
            var t = new Tamanio_Tablero();
            // Eliminamos cada celda del panel
            t.LimpiarTablero(panel);
            // Crea nueva celdas con el tamaño asignado
            t.AsignarTamanio(tamanio, panel);
            // Se crea un objeto Labals_Tablero
            var lt = new Labels_Tablero();
            // Se elimina los labels que quedan
            lt.LiberarLabels(panel);
            var c = new Creacion_Labels();
            // Devuelve una matriz de labels de cierto tamaño
            var labels = c.CrearLabels(tamanio, panel);
            // Rellena la matriz de labels con cada celda del panel
            lt.AsignarLabels(labels, panel);
        }
        // Funcion que inicializa las componentes del tablero
        public void IniciarTablero(TableLayoutPanel panel)
        {
            // Se crea  un objeto Creacion_Labels
            var c = new Creacion_Labels();
            // se guarda en labels la matriz de labels de tamaño 1
            var labels = c.CrearLabels(1, panel);
            var l = new Labels_Tablero();
            // Se rellena esa matriz labels con las celdas del panel
            l.AsignarLabels(labels, panel);
        }
    }
}
