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
            "S","O","Blue","Red"
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
            //se asegura de que el jugadorAzul tenga que hacer un movimiento
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
                //asigna S si está seleccionado en su radioButton, de lo contrario selecciona O
                jugadorAzul.Text = (radioButton3.Checked == true) ? SO[0] : SO[1]; 
                jugadorAzul.Font=new Font("Microsoft Sans Serif", 24, FontStyle.Bold);    
                jugadorAzul.ForeColor = Color.Blue;
                //Avisa que es turno del jugadorRojo
                label7.Text = SO[3];
                label7.ForeColor = Color.Red;
                return;

            }
            //aquí el jugadorRojo hace su movimiento
            jugadorRojo = clickedLabel;
            //Al igual que en las instrucciones anteriores, cambia el tamaño de la fuente y el color, además
            //de ponerlo en negrita
            jugadorRojo.Text= (radioButton5.Checked == true) ? SO[0] : SO[1];
            jugadorRojo.Font = new Font("Microsoft Sans Serif", 24, FontStyle.Bold);
            jugadorRojo.ForeColor = Color.Red;
            //se pone ambos labels en null para que puedan realizar el siguiente movimiento
            jugadorRojo = null;
            jugadorAzul = null;
            //Avisa que es turno del jugadorAzul
            label7.Text = SO[2];
            label7.ForeColor = Color.Blue;
            return;
        }
    }
}
