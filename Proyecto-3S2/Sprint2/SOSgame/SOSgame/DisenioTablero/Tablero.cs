using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SOSgame.Tablero
{
    public class CreacionTablero
    {
        public void CambiarTablero(int tamanio,TableLayoutPanel panel)
        {
            var t = new Tamanio_Tablero();
            t.LimpiarTablero(panel);
            t.AsignarTamanio(tamanio, panel);
            var lt = new Labels_Tablero();
            lt.LiberarLabels(panel);
            var c = new Creacion_Labels();
            var labels = c.CrearLabels(tamanio, panel);
            lt.AsignarLabels(labels, panel);
        }
        public void IniciarTablero(TableLayoutPanel panel)
        {
            var c = new Creacion_Labels();
            var labels = c.CrearLabels(1, panel);
            var l = new Labels_Tablero();
            l.AsignarLabels(labels, panel);
        }
    }
}
