using Microsoft.VisualStudio.TestTools.UnitTesting;
using SOSgame;
using System;
using System.Collections.Generic;
using System.Net.NetworkInformation;
using System.Reflection.Emit;

namespace UnitTestSOSgame
{
    [TestClass]
    public class UnitTest1
    {
        List<string> SO = new List<string>()
        {
            "S","O", ""
        };
        [TestMethod]
        public void Juego_Simple_Terminado()
        {
            int tamanio = 3;
            string[,] juego_prueba = new string[tamanio,tamanio];
            Random aleat = new Random();
            for(int i = 0;i<tamanio;i++)
            {
                for(int j = 0;j<tamanio;j++)
                {
                    juego_prueba[i, j] = SO[aleat.Next(0, 3)];
                }
            }
            var simple = new JuegoSimple(tamanio);
            simple.grid = juego_prueba;
            Assert.IsTrue(simple.JuegoTerminado());
        }
        [TestMethod]
        public void Juego_General_Tablero_Lleno()
        {
            int tamanio = 3;
            string[,] juego_prueba = new string[tamanio, tamanio];
            Random aleat = new Random();
            for (int i = 0; i < tamanio; i++)
            {
                for (int j = 0; j < tamanio; j++)
                {
                    juego_prueba[i, j] = SO[aleat.Next(0, 3)];
                }
            }
            var general = new JuegoGeneral(tamanio);
            Assert.IsTrue(general.TableroLleno());
        }
        [TestMethod]
        public void Juego_General_Terminado()
        {
            int tamanio = 3;
            string[,] juego_prueba = new string[tamanio, tamanio];
            Random aleat = new Random();
            for (int i = 0; i < tamanio; i++)
            {
                for (int j = 0; j < tamanio; j++)
                {
                    juego_prueba[i, j] = SO[aleat.Next(0, 2)];
                }
            }
            var general = new JuegoGeneral(tamanio);
            Assert.IsTrue(general.JuegoTerminado());
        }
    }

}
