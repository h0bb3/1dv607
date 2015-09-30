using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OOAD_Workshop2.model;
using OOAD_Workshop2.view;

namespace OOAD_Workshop2.control
{
    /// <summary>
    /// Controller
    /// </summary>
    class Application
    {
        private Menu menu = new Menu();
        private Registration registration;
        private ConsoleView view;
        private Member _selectedMember;

        public Application(ConsoleView view, Registration registration)
        {
            this.registration = registration;
            this.view = view;
        }



        public bool Run()
        {

            Menu.MenuItems menuItem = menu.GetMenuEvent();

            //Terminate application
            if (menuItem == Menu.MenuItems.Quit)
            {
                return false;
            }
            //Keyboard input is not valid
            if(menuItem == Menu.MenuItems.NoAction)
            {
                view.ClearCharacter();
                return true;
            }
            //Run application
            else
            {
                //Show Menu
                menu.ShowMenu(menuItem);

                //New Member
                if(menuItem == Menu.MenuItems.NewMember)
                {
                    newMember();
                }
                //Show list of members (compact list)
                if (menuItem == Menu.MenuItems.ShowCompactList)
                {
                    showCompactList();
                }

                if (menuItem == Menu.MenuItems.SelectMember)
                {
                    selectMember();
                }

                if (menuItem == Menu.MenuItems.DeleteMember)
                {
                    if(view.ShowDeleteMember())
                    {
                        deleteMember();
                        menu.ShowMenu(Menu.MenuItems.Main);
                    }
                    else
                    {
                        menu.ShowMenu(Menu.MenuItems.Member);
                        view.ShowMember(_selectedMember);
                    }
                   
                }
                if (menuItem == Menu.MenuItems.UpdateMember)
                {
                    updateMember();
                }
                if(menuItem == Menu.MenuItems.NewBoat)
                {
                    addBoat();
                }
                if(menuItem == Menu.MenuItems.DeleteBoat)
                {
                    deleteBoat();
                }
                if (menuItem == Menu.MenuItems.UpdateBoat)
                {
                    updateBoat();
                }
                if (menuItem == Menu.MenuItems.ShowVerboseList) 
                {
                    showVerboseList();
                }

                return true;
            }
        }

        private void newMember()
        {
            //Show input form
            view.InputFormNewMember();
            //Input
            string name = view.MemberNameInput;
            string no = view.MemberPersonalNoInput;
            //Saves data
            registration.Save(new Member(name, no));


            // back to main menu
            menu.ShowMenu(Menu.MenuItems.Main);
        }

        private void showCompactList()
        {
            //Show menu
            menu.ShowMenu(Menu.MenuItems.Members);
            //Fetch members and show
            var memberList = registration.GetListOfMembers();
            view.ShowMemberList(memberList);
        }

        private void showVerboseList()
        {
            //Show menu
            menu.ShowMenu(Menu.MenuItems.Members);
            var memberlist = registration.GetListOfMembers();
            view.ShowVerboseMemberList(memberlist);
        }

        private void selectMember()
        {
            menu.ShowMenu(Menu.MenuItems.Members);
            //fetch list of members and show 
            var memberList = registration.GetListOfMembers();
            view.ShowMemberList(memberList);
            //Show form for selection of members
            view.ShowFormSelectMember();
            //Input member Id fetch member info from persistent data
            Member member = registration.GetMemberInformation(view.MemberId);
            //Show menu
            menu.ShowMenu(Menu.MenuItems.Member);
            //_selectedMember gets its value, so it can be used in other operations
            _selectedMember = member;
            //Show member information
            view.ShowMember(member);
            //view.ShowListOfBoats(member);
        }

        private void deleteMember()
        {
            registration.DeleteMember(_selectedMember);
        }

        private void updateMember()
        {
            //show Form for updating member
            view.ShowFormUpdateMember(_selectedMember);
            //Updates info in _selectedMember with info from user input
            _selectedMember.Name = view.MemberNameInput;
            _selectedMember.PersonalNumber = view.MemberPersonalNoInput;

            //Updates member info in database
            registration.UpdateMember(_selectedMember);
            //Show member menu
            menu.ShowMenu(Menu.MenuItems.Member);
            //Show selected member
            view.ShowMember(_selectedMember);
        }

        private void addBoat()
        {
            //Show form for adding boat to user
            view.ShowFormAddBoat(_selectedMember);
            //Add boat to user in database
            registration.AddBoat(_selectedMember, new Boat(view.TypeOfBoat, view.Length));
            //Show member menu
            menu.ShowMenu(Menu.MenuItems.Member);
            //Show member information
            view.ShowMember(_selectedMember);
        }

        private void deleteBoat()
        {
            view.ShowListOfBoats(_selectedMember);
            view.ShowFormDeleteBoat(_selectedMember);

            Boat toBeDeleted = (from b in _selectedMember.Boats
                                where view.BoatId == b.Id
                                select b).FirstOrDefault();
            
            registration.DeleteBoat(_selectedMember, toBeDeleted);
            //Show menu
            menu.ShowMenu(Menu.MenuItems.Member);
            //Show member information
            view.ShowMember(_selectedMember);
        }

        private void updateBoat()
        {
            view.ShowListOfBoats(_selectedMember);
            view.ShowFormUpdateBoat(_selectedMember);

            Boat toBeUpdated = (from b in _selectedMember.Boats
                                where view.BoatId == b.Id
                                select b).FirstOrDefault();


            registration.UpdateBoat(_selectedMember, toBeUpdated, view.TypeOfBoat, view.Length );
            //Show menu
            menu.ShowMenu(Menu.MenuItems.Member);
            //Show member information
            view.ShowMember(_selectedMember);
        }


    }
}
