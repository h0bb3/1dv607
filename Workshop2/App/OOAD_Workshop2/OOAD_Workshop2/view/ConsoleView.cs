using OOAD_Workshop2.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OOAD_Workshop2.model;
using System.Windows.Forms;
using System.Globalization;


namespace OOAD_Workshop2.view
{
    public class ConsoleView
    {        


        public string MemberNameInput { get; private set; }
        public string MemberPersonalNoInput { get; private set; }
        public int MemberId { get; private set; }
        public int BoatId { get; private set; }
        public BoatType TypeOfBoat { get; private set; }
        public float Length { get; private set; }


        private static Menu ConsoleMenu;

        public ConsoleView(Menu menu)
        {
            ConsoleMenu = menu;
            
        }

        public void DisplayMenu(Menu.MenuItems item)
        {
            ConsoleMenu.ShowMenu(item);
        }

        public void ClearCharacter()
        {
            Console.Write("\b \b");
        }

        public bool InputFormNewMember()
        {
            Console.WriteLine("**Register new member**");
            Console.Write("Name: ");
            MemberNameInput = Console.ReadLine();
            Console.Write("PersonalNo.: ");
            MemberPersonalNoInput = Console.ReadLine();

            char c = ' ';

            while (c != 's'  && c != 'c')
            { 
                Console.WriteLine("S=Save\t C=Cancel");
                c = Console.ReadKey().KeyChar;
                ClearCharacter();
            }
            if (c == 's')
            {
                return true;
            }
            return false;
        }

        public void ShowMemberList(IEnumerable<Member> members)
        {
            foreach(Member member in members)
            {
                Console.WriteLine("{0}) {1}  {2} ", member.UniqueId, member.Name, member.PersonalNumber);
            }
        }

        public void ShowVerboseMemberList(IEnumerable<Member> members)
        {
            foreach(Member member in members)
            {
                Console.WriteLine("{0}) {1} {2}",
                    member.UniqueId,
                    member.Name,
                    member.PersonalNumber);
                Console.WriteLine("---List of Boats---");
                Console.WriteLine("Number of boats: {0}", member.Boats.Count);
                foreach (Boat boat in member.Boats)
                {
                    Console.WriteLine("Type: {0} Length: {1}", boat.BoatType, boat.Length);
                }
                Console.WriteLine("***************************************");
            }
        }

        public void ShowMember(Member member)
        {
            Console.WriteLine("**Member information**");
            Console.WriteLine("ID: {0}", member.UniqueId);
            Console.WriteLine("Name: {0}", member.Name);
            Console.WriteLine("PersonalNo.: {0}", member.PersonalNumber);
            Console.WriteLine("No. of boats: {0}", member.Boats.Count);

            if (member.Boats.Count > 0)
            {
                ShowListOfBoats(member);
            }
            

        }
        public void ShowListOfBoats(Member member)
        {
            Console.WriteLine("**List of Boats**");
            foreach (var boat in member.Boats)
            {
                Console.WriteLine("{0}) Type: {1}. Length: {2}", (boat.Id), boat.BoatType, boat.Length);
            }
        }

        public void ShowFormSelectMember()
        {
            Console.Write("Select ID of member: ");
            MemberId = Convert.ToInt32(Console.ReadLine());
        }

        public bool ShowDeleteMember()
        {
            Console.Write("Delete member? y/n: ");
            char c = ' ';

            //Accept only char y and n
            while (c != 'y' && c != 'n')
            {
                c = Console.ReadKey().KeyChar;
                ClearCharacter();
            }
            if (c == 'y')
            {
                return true;
            }
            return false;
        }

        public void ShowFormUpdateMember(Member selected)
        {
            Console.WriteLine("**UpdateMember**");
            Console.Write("Name:");
            SendKeys.SendWait(selected.Name);
            MemberNameInput = Console.ReadLine();
            Console.Write("PersonalNo.:");
            SendKeys.SendWait(selected.PersonalNumber);
            MemberPersonalNoInput = Console.ReadLine();
        }

        public void ShowFormAddBoat(Member selected)
        {
            BoatType boatType;

            Console.WriteLine("**Add Boat Information**");
            
            foreach (BoatType boat in Enum.GetValues(typeof(BoatType)))
            {
                Console.WriteLine("{0}){1} ", (int)boat, boat);
            }
            Console.Write("Enter type: ");
            string indataType = Console.ReadLine();
            Enum.TryParse(indataType, out boatType);
            Console.Write("Enter length: ");
            string indataLength = Console.ReadLine();
            //Save to properties
            this.TypeOfBoat = boatType;
            this.Length = float.Parse(indataLength.Replace('.', ','));
        }

        public void ShowFormDeleteBoat(Member selected)
        {
            int id;
            Console.WriteLine("**Delete Boat**");
            Console.Write("Enter ID of boat to delete: ");
            int.TryParse(Console.ReadLine(), out id);

            BoatId = id;
        }

        public void ShowFormUpdateBoat(Member selected)
        {
            int id;
            Console.WriteLine("**UpdateBoat**");
            Console.Write("Enter ID of boat to be updated: ");
            int.TryParse(Console.ReadLine(), out id);
            Console.Clear();

            BoatId = id;
            BoatType type = (from t in selected.Boats
                             where t.Id == id
                             select t.BoatType).FirstOrDefault();
            float length = (from t in selected.Boats
                            where t.Id == id
                            select t.Length).FirstOrDefault();
            Console.WriteLine("**Current values**");
            Console.WriteLine("Type: " + type.ToString());
            Console.WriteLine("Length: " + length.ToString());
            Console.WriteLine();
            Console.WriteLine("**Update information**");
            ShowFormAddBoat(selected);

            
        }



    }//Class
}//Namespace
