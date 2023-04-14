using SOSgame.Tablero;
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
        //Lista que funciona como diccionario                      
        List<string> SO = new List<string>()
            {
                "S","O","Blue","Red"
            };
        Label jugadorAzul, jugadorRojo;
        public Form1()
        {
            InitializeComponent();
        }
        // Funcion de Evento de cambio de tamaño de tablero
        private void NumericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            // Por cada cambio se crea un nuevo tablero
                                                                                                                                                                                                  
            var t = new CreacionTablero();
            // Se establece el tamaño del tablero                              
            t.CambiarTablero((int)numericUpDown1.Value, tableLayoutPanel1);
            // Agrega la funcion de evento AsignarSo a cada label del tablero
            foreach (Label label in tableLayoutPanel1.Controls.OfType<Label>())
                label.Click += AsignarSO;
            /*
            de forma convencional sería, teniendo la matriz de labels
            Label[,] labels;
            for (int i = 0; i< (int)numericUpDown1.Value;i++)
                for (int j = 0; j< (int)numericUpDown1.Value;j++)
                    labels[i,j].Click += AsignarSO;
            */
            // Actualizamos los Labels jugador para que empiece siempre el azul
            jugadorAzul = null;
            jugadorRojo = null;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            var t = new CreacionTablero();
            t.IniciarTablero(tableLayoutPanel1);
            foreach (Label label in tableLayoutPanel1.Controls.OfType<Label>())
                label.Click += AsignarSO;

        }
        // Funcion de evento de click en label para asignar un S o O
        public void AsignarSO(object sender, EventArgs e)
        {
            // el objeto sender lo convierte a un objeto tipo label
            Label clickedLabel = sender as Label;
            //si no se puede convertir a label, no hace nada
            if (clickedLabel == null)
                return;
            //si se hace click en una casilla ya marcada con S u O, no hace nada
            if (!string.IsNullOrEmpty(clickedLabel.Text))
                return; // para no reescribir
                        //se asegura de que el jugadorAzul tenga que hacer un movimiento
            
            // Siempre empieza el azul
            if (jugadorAzul == null)
            {
                // El jugador Azul deja de ser nulo
                jugadorAzul = clickedLabel;
                /*
                 implementación if ternario
                if (radioButton3.Checked == true)
                    jugadorAzul.Text = SO[0]; 
                if (radioButton4.Checked == true)
                    jugadorAzul.Text = SO[1];
                */

                //asigna S si está seleccionado en su radioButton, de lo contrario selecciona O
                jugadorAzul.Text = (radioButton3.Checked == true) ? SO[0] : SO[1];
                // Cambia de color La letra del label
                jugadorAzul.ForeColor = Color.Blue;
                //Avisa que es turno del jugadorRojo
                label7.Text = SO[3];
                label7.ForeColor = Color.Red;
                return;
            }
            else
            {
                //aquí el jugadorRojo hace su movimiento
                jugadorRojo = clickedLabel;
                //Al igual que en las instrucciones anteriores, cambia el tamaño de la fuente y el color, además
                //de ponerlo en negrita
                jugadorRojo.Text = (radioButton5.Checked == true) ? SO[0] : SO[1];
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
}
