using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SOSgame
{
    public partial class Form1 : Form
    {
        List<string> SO = new List<string>()
        {
            "S","O"
        };
        Label jugadorAzul, jugadorRojo;
        public Form1()
        {

            InitializeComponent();
        }
        private void Asignar_S_O(object sender, EventArgs e)
        {
            Label clickedLabel = sender as Label;
            //si no se puede convertir a label, no hace nada
            if (clickedLabel == null)
                return;
            //si se hace click en una casilla ya marcada con S u O, no hace nada
            if (!string.IsNullOrEmpty(clickedLabel.Text))
                return; // para no reescribir
            if (jugadorAzul == null)
            {
                jugadorAzul = clickedLabel;
                /*
                if (radioButton3.Checked == true)
                    jugadorAzul.Text = SO[0]; 
                if (radioButton4.Checked == true)
                    jugadorAzul.Text = SO[1];
                */
                //implementación if ternario
                //asigna S si está seleccionado en su raddioButton, de lo contrario selecciona O
                jugadorAzul.Text = (radioButton3.Checked == true) ? SO[0] : SO[1]; 
                jugadorAzul.Font=new Font("Microsoft Sans Serif", 24, FontStyle.Bold);    
                jugadorAzul.ForeColor = Color.Blue;
                return;

            }else if(jugadorRojo == null)
            {
                jugadorRojo = clickedLabel;
                jugadorRojo.Text= (radioButton5.Checked == true) ? SO[0] : SO[1];
                jugadorRojo.Font = new Font("Microsoft Sans Serif", 24, FontStyle.Bold);
                jugadorRojo.ForeColor = Color.Red;
                jugadorRojo = null;
                jugadorAzul = null;
                return;
            }
        }
        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void groupBox3_Enter(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        public void tableLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }

        private void tableLayoutPanel1_MouseClick(object sender, MouseEventArgs e)
        {

        }
    }
}
