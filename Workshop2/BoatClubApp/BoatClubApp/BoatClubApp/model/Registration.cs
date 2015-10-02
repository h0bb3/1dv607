using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoatClubApp.model
{
    class Registration
    {
        private List<Member> members;

        public Registration()
        {
            members = new List<Member>();
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
