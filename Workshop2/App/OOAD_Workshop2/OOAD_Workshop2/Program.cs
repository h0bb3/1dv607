using OOAD_Workshop2.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OOAD_Workshop2.view;
using OOAD_Workshop2.control;


namespace OOAD_Workshop2
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.SetWindowSize((int)(Console.WindowWidth * 1.2), Console.WindowHeight);
            Console.Title = "Workshop 2";
            var menu = new Menu();

            var db = new RegistrationDAL();
            var reg = new Registration(db);
            var V_console = new ConsoleView(menu);

            var C_app = new Application(V_console, reg);

            V_console.DisplayMenu(Menu.MenuItems.Main);

            //Simple error handling. Application starts over if an exception is thrown.
            Start:
            try
            {
                while (C_app.Run()) ;
            }
            catch
            {
                Console.Clear();
                V_console.DisplayMenu(Menu.MenuItems.Main);
                Console.Write("Something went wrong. Please try again");
                goto Start;
            }
            

        }
    }
}
