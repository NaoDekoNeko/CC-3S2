using Microsoft.VisualStudio.TestTools.UnitTesting;
using ReSOSgame;
using System;

namespace UnitTest1
{
    [TestClass]
    public class Requisito1
    {
        private Tablero tablero;
        private Juego juego;
        [TestInitialize]
        public void Init()
        {
            tablero = new Tablero(3);
            juego = new JuegoSimple(tablero);
        }

        [TestMethod]
        [ExpectedException(typeof(Exception))]
        public void OutOfGridX()
        {
            juego.Jugar(5, 2,Tablero.Cell.S);
        }
        [TestMethod]
        [ExpectedException(typeof(Exception))]
        public void OutOfGridY()
        {
            juego.Jugar(3, 7,Tablero.Cell.S);
        }
        [TestMethod]
        public void AlreadyOccupied()
        {
            juego.Jugar(3, 3, Tablero.Cell.S);
            juego.Jugar(3, 3, Tablero.Cell.O);
            //se va a comprobar que el movimiento de O no se haya hecho y solo se haya realizado el movimiento X
            Assert.AreEqual(Tablero.Cell.S, tablero.GetCell(3, 3));
        }
    }
}
