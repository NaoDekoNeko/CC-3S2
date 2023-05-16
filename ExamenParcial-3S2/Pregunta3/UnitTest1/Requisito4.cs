using Microsoft.VisualStudio.TestTools.UnitTesting;
using ReSOSgame;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest1
{
    [TestClass]
    public class Requisito4
    {
        private Juego juego;
        private Tablero tablero;
        [TestInitialize]
        public void Init()
        {
            tablero = new Tablero(3);
            juego = new JuegoSimple(tablero);
        }
        [TestMethod]
        public void DrawFullBoard()
        {
            for(int i = 1; i <= tablero.Tamanio; i++)
            {
                for(int j=1;j <= tablero.Tamanio; j++)
                {
                    juego.Jugar(i,j,Tablero.Cell.S);
                }
            }
            Assert.IsTrue(juego.TableroLLeno());
        }
    }
}
