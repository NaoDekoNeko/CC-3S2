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
    public class Refactorizacion
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
        public void Winner()
        {
            juego.Jugar(1, 1, Tablero.Cell.S);
            juego.Jugar(2, 1, Tablero.Cell.O);
            //juego.Jugar(3, 1, Tablero.Cell.S);
            Assert.IsTrue(juego.Win(3,1,Tablero.Cell.S));
        }
    }
}
