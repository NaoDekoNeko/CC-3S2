using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SOSgame.Tablero
{
    public class Creacion_Labels
    {
        public Creacion_Labels() { }
        public Label[,] CrearLabels(int tamanio,TableLayoutPanel panel)
        {
            panel.ColumnCount = tamanio;
            panel.RowCount = tamanio;
            int tamanio_inicial = panel.ColumnCount;
            Label[,] labels = new Label[tamanio, tamanio];
            for(int i = 0; i < tamanio; i++)
            {
                for (int j = 0; j < tamanio; j++)
                {
                    if(i<tamanio_inicial)
                        labels[i, j] = new Label
                        {
                            AutoSize = true,
                            Dock = DockStyle.Fill,
                            Name = "label" + i + j,
                            Font = new Font("Microsoft Sans Serif", 24, FontStyle.Bold),
                            Text = null,
                            TextAlign = ContentAlignment.MiddleCenter
                        };
                }
            }
            return labels;
        }
    }
}
