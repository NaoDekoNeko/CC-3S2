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
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            double X1 = Convert.ToDouble(textBox1.Text);
            double Y1 = Convert.ToDouble(textBox2.Text);
            var distancia = new Distancia();
            var coordenadas = new Coordenada(X1,Y1);
            var resutlado = distancia.calcularDistancia(coordenadas);
            textBox5.Text = resutlado.ToString();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            
        }
    }
}
