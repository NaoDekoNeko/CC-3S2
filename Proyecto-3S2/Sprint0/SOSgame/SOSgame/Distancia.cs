using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SOSgame
{
    public class Distancia    {
        // Función que calcula la distancia de un punto al Origen
        public double calcularDistancia(Coordenada punto)
        {
            return Math.Sqrt(Math.Pow(punto.getX(), 2) + Math.Pow(punto.getY(), 2));
        }
    }
}
