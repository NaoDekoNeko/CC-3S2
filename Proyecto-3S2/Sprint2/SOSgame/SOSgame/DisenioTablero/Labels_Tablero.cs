using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SOSgame.Tablero
{
    public class Labels_Tablero
    {
        public void AsignarLabels(Label[,] labels,TableLayoutPanel panel)
        {
            foreach (Label label in labels)
            {
                panel.Controls.Add(label);
            }
        }
        public void LiberarLabels(TableLayoutPanel panel)
        {
            panel.Controls.Clear();
        }
    }
}
