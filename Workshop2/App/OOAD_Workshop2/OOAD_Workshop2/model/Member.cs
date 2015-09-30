using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace OOAD_Workshop2.model
{
    [Serializable]
    public class Member
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

        public List<Boat> Boats { get; set; }


        public Member(string name, string personalNumber)
        {
            this.Name = name;
            this.PersonalNumber = personalNumber;
            Boats = new List<Boat>();
        }
    }
}
