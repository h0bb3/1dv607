using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {

            
            Console.WriteLine("Line 1");
            Console.WriteLine("Line 2");
            Console.SetCursorPosition(0, Console.CursorTop - 2);
            Console.WriteLine(new String(' ', Console.BufferWidth));

            Console.ReadKey();

            

        }
    }
}
