using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BoatClubApp.model
{
    class Member
    {
        private int unique;

        public string Name { get; set; }
        public string PersonalNumber { get; set; }
        public int UniqueId
        {
            get
            {
                return unique;
            }
            set
            {
                unique = value;
            }
        }
        public Member(string name, string personalNumber)
        {
            this.Name = name;
            this.PersonalNumber = personalNumber;
        }
    }
}
