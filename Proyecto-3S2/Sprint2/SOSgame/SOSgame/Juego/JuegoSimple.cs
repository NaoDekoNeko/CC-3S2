using System.Security.Cryptography.X509Certificates;
using System.Windows.Forms;

namespace SOSgame
{
    public class JuegoSimple:Juego,IJuegoTerminado
    {
        
        public JuegoSimple(int tamanio) : base(tamanio){ }

        public bool JuegoTerminado()
        {
            return false;
        }
    }
}