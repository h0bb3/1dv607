using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOAD_Workshop2.model
{
    
    public enum BoatType
    {
        Sailboat = 1,
        Motorsailer,
        KayakCanoe,
        Other
    }

    [Serializable]
    public class Boat
    {
        public int Id { get; set; }
        public BoatType BoatType { get; set; }
        public float Length { get; set; }

        public Boat(BoatType boatType, float length)
        {
            this.BoatType = boatType;
            this.Length = length;
        }

    }
}
