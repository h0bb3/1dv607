using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOAD_Workshop2.model
{
    public interface IRegistrationDAL
    {
        void Save(List<Member> memberList);
        List<Member> Load();
    }
}
