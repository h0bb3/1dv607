using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BoatClubApp.model;


namespace BoatClubApp.control
{
    class App
    {
        private List<Member> members;

        public App()
        {
            members = new List<Member>();
            var a = new Member("Andreas", "770214-2451");
            var b = new Member("Noa", "34567");
            var reg = new Registration();
            reg.Save(a);
            reg.Save(b);
        }

        public void Save(Member newMember)
        {
            newMember.UniqueId = generateUniqueId();
            members.Add(newMember);
        }

        private int generateUniqueId()
        {
            if (members.Count == 0)
            {
                return 1;
            }

            int highestId = members.Max(mem => mem.UniqueId);
            return highestId + 1;
        }

        public IEnumerable<Member> GetListOfMembers()
        {
            return members;
        }
    }

}
