using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace GreenFoxPractice
{
    class FileTest
    {
        public static void WriteFile(string fileName)
        {
            File.WriteAllText(fileName, "Hello World!");
        }

        public static void ReadFile(string fileName)
        {
            Console.WriteLine(File.ReadAllText(fileName));
        }

        public static void WriteFileAdvanced(string fileName)
        {
            FileStream fileStream = new FileStream(fileName, FileMode.Create, FileAccess.Write);

            if (fileStream.CanWrite)
            {
                byte[] buffer = Encoding.ASCII.GetBytes("Hello again...");
                fileStream.Write(buffer, 0, buffer.Length);
            }
            fileStream.Flush();
            fileStream.Close();
        }

        public static void ReadFileAdvanced(string fileName)
        {
            FileStream fileStream = new FileStream(fileName, FileMode.Open, FileAccess.Read);

            if (fileStream.CanRead)
            {
                byte[] buffer = new byte[fileStream.Length];
                int bytesRead = fileStream.Read(buffer, 0, buffer.Length);
                fileStream.Read(buffer, 0, buffer.Length);
                Console.WriteLine(Encoding.ASCII.GetString(buffer, 0, bytesRead));
            }
            fileStream.Close();
        }

        public static void WriteFileUsing(string fileName)
        {
            string[] lines = {"And it seems I'm getting smaller", "Every day I feel minute", "Or is it you who's growing taller", "And the world just follows suit"};
            using (StreamWriter writer = new StreamWriter(fileName))
            {
                foreach (string line in lines)
                {
                    writer.WriteLine(line);
                }
            }
        }

        public static void DivideByZero()
        {
            try
            {
                int x = 11;
                int y = 0;
                double z = x / y;
            }
            catch(Exception error)
            {
                Console.WriteLine(error.Message);
                Console.ReadKey();
            }
        }
    }
}
