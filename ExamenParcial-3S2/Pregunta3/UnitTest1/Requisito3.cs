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
    public class Requisito3
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
        public void NoWinner()
        {
            Assert.IsFalse(juego.HayGanador());
        }
        [TestMethod]
        public void HorizontalWin()
        {
            juego.Jugar(1, 1, Tablero.Cell.S);
            juego.Jugar(1, 2, Tablero.Cell.O);
            juego.Jugar(1, 3, Tablero.Cell.S);
            Assert.IsTrue(juego.PuntoHorizontal());
        }
        [TestMethod]
        public void VerticalWin()
        {
            juego.Jugar(1, 1, Tablero.Cell.S);
            juego.Jugar(2, 1, Tablero.Cell.O);
            juego.Jugar(3, 1, Tablero.Cell.S);
            Assert.IsTrue(juego.PuntoVertical());
        }
        [TestMethod]
        public void LeftDiagWin()
        {
            juego.Jugar(1, 1, Tablero.Cell.S);
            juego.Jugar(2, 2, Tablero.Cell.O);
            juego.Jugar(3, 3, Tablero.Cell.S);
            Assert.IsTrue(juego.PuntoDiagIzq());
        }
        [TestMethod]
        public void RightDiagWin()
        {
            juego.Jugar(1, 3, Tablero.Cell.S);
            juego.Jugar(2, 2, Tablero.Cell.O);
            juego.Jugar(3, 1, Tablero.Cell.S);
            Assert.IsTrue(juego.PuntoDiagDer());
        }
    }
}
