using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SOSgame
{
    public class JuegoGeneral : Juego, IJuegoTerminado,ITableroLLeno
    {
        bool lleno;
        int sosAzul;
        int sosRojo;
        public JuegoGeneral(int tamanio) : base(tamanio){ }

        public bool JuegoTerminado()
        {
            return false;
        }

        public bool TableroLleno()
        {
            return false;
        }
    }
}
