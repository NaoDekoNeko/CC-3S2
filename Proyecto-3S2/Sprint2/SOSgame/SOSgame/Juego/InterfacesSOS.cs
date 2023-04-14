using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SOSgame
{
    public interface IJuegoTerminado
    {
        bool JuegoTerminado();
    }
    public interface ITableroLLeno 
    {
        bool TableroLleno();
    }

}
