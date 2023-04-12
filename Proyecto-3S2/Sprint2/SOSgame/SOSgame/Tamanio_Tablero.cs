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
    public class Tamanio_Tablero:Form1
    {
        public void Asignar_Tamanio(int tamanio, TableLayoutPanel panel)
        {
            panel.ColumnCount = tamanio;
            panel.RowCount = tamanio;
            for (int i = 0; i < tamanio; i++)
                panel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100 / tamanio));
            for (int i = 0; i < tamanio; i++)
                panel.RowStyles.Add(new RowStyle(SizeType.Percent, 100 / tamanio));
            //MessageBox.Show("funciona i guess");
        }
    }
}
