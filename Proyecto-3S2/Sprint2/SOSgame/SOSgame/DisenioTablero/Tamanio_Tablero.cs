using SOSgame.Tablero;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;
using TextBox = System.Windows.Forms.TextBox;

namespace SOSgame
{
    public class Tamanio_Tablero
    {
        public void AsignarTamanio(int tamanio,TableLayoutPanel panel)
        {
            panel.ColumnCount = tamanio;
            panel.RowCount = tamanio;
            int tamanio_inicial = panel.ColumnCount;
            for (int i = 0; i < tamanio; i++)
            {
                
                if (i<tamanio_inicial)
                {
                    //hace el resize equitativo para los Rows y Columns existentes
                    panel.RowStyles[i].Height = 100 / tamanio;
                    panel.RowStyles[i].SizeType = SizeType.Percent;
                    panel.ColumnStyles[i].Width = 100/tamanio;
                    panel.ColumnStyles[i].SizeType = SizeType.Percent;
                }
                //Hace el resize equitativo para los Rows y Columns recién creados
                panel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100 / tamanio));
                panel.RowStyles.Add(new RowStyle(SizeType.Percent, 100 / tamanio));
            }
        }
        public void LimpiarTablero(TableLayoutPanel panel)
        {
            for(int i=0; i<panel.ColumnCount; i++)
            {
                for(int j=0; j<panel.RowCount; j++)
                {
                    Control control = panel.GetControlFromPosition(i, j);
                    panel.Controls.Remove(control);
                }
            }
        }
    }
}
