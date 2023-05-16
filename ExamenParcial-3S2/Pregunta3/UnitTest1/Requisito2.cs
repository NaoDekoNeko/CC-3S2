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
    public class Requisito2
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
        public void BluePlaysFirst()
        {
            Assert.AreEqual(tablero.Turno, Tablero.Jugador.AZUL);
        }
        [TestMethod]
        public void RedPlaysAfterBlue()
        {
            juego.Jugar(1, 1,Tablero.Cell.S);
            Assert.AreEqual(tablero.Turno, Tablero.Jugador.ROJO);
        }
    }
}
