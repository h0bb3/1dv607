using OOAD_Workshop2.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOAD_Workshop2.view
{ 
    public class Menu
    {


        public enum MenuItems
        {
            Main,
            Members,
            Member,
            Boat,
            //
            NewMember,
            ShowCompactList,
            ShowVerboseList,
            //
            SelectMember,
            DeleteMember,
            UpdateMember,
            //
            NewBoat,
            DeleteBoat,
            UpdateBoat,
            //
            Quit,
            NoAction
        }

       
        private string showMessage(string message)
        {
            return message;
        }


        public void ShowMenu(MenuItems item)
        {

            //set colors in menu
            Console.Clear();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.BackgroundColor = ConsoleColor.White;

            switch (item)
            {
                case MenuItems.Main:
                    Console.WriteLine("Main Menu");
                    Console.WriteLine("N=New Member\t K=Compact List\t L=Verbose List\t Q=Quit");
                    break;
                case MenuItems.Members:
                    Console.WriteLine("Members");
                    Console.WriteLine("S=Select\t H=Main Menu");
                    break;
                case MenuItems.Member:
                    Console.WriteLine("Member");
                    Console.WriteLine("D=Delete Member  C=Change Member  J=Add Boat  R=Delete Boat  E=Change Boat  H=Main Menu");
                    break;
            }

            Console.ResetColor();
        }

        public MenuItems GetMenuEvent()
        {
            char c = Console.ReadKey().KeyChar;
            Menu.MenuItems item;
            
            switch (c)
            {
                case 'h':
                    item = Menu.MenuItems.Main;
                    break;
                case 'm':
                    item = Menu.MenuItems.Member;
                    break;
                case 'q':
                    item = Menu.MenuItems.Quit;
                    break;
                case 'n':
                    item = Menu.MenuItems.NewMember;
                    break;
                case 'k':
                    item = Menu.MenuItems.ShowCompactList;
                    break;
                case 'l':
                    item = Menu.MenuItems.ShowVerboseList;
                    break;
                case 's':
                    item = Menu.MenuItems.SelectMember;
                    break;
                case 'd':
                    item = Menu.MenuItems.DeleteMember;
                    break;
                case 'c':
                    item = Menu.MenuItems.UpdateMember;
                    break;
                case 'j':
                    item = Menu.MenuItems.NewBoat;
                    break;
                case 'r':
                    item = Menu.MenuItems.DeleteBoat;
                    break;
                case 'e':
                    item = Menu.MenuItems.UpdateBoat;
                    break;
                default:
                    item = Menu.MenuItems.NoAction;
                    break;
            }

            return item;
        }
             
        

    }//class
}//namespace

