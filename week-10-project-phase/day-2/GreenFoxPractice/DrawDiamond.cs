using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GreenFoxPractice
{
    class DrawDiamond
    {
        public static void Diamond(int numberOfRows)
        {
            int halfOfRows = (numberOfRows + 1) / 2;
            for (int i = 0; i < halfOfRows; i++)
            {
                DrawHalfDiamond(halfOfRows, i);           
            }
            for (int i = halfOfRows - 2; i >= 0; i--)
            {
                DrawHalfDiamond(halfOfRows, i);
            }
        }

        public static void DrawHalfDiamond(int halfOfRows, int i)
        {
            for (int j = halfOfRows - i; j > 0; j--)
            {
                Console.Write(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++)
            {
                Console.Write("*");
            }
            Console.WriteLine("");
        }
    }
}
