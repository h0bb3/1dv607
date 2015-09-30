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
            var c_view = new ConsoleView(menu);
            var app = new Application(c_view, reg);

            c_view.DisplayMenu(Menu.MenuItems.Main);

            while (app.Run());

        }
    }
}
