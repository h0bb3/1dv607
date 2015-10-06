using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Reflection;
using System.Runtime.Serialization.Formatters.Binary;

namespace OOAD_Workshop2.model
{
    class RegistrationDAL : IRegistrationDAL
    {

        private static readonly string dir = Environment.CurrentDirectory;
        private static readonly string filePath = dir + @"\db.bin";

        //Saves List<Member> to file in disk
        public void Save(List<Member> memberList)
        {
            try
            {
                //using (FileStream fileStream = new FileStream(@"\db.bin", FileMode.Create))
                using (Stream stream = File.Open(filePath, FileMode.Create))
                {
                    var formatter = new BinaryFormatter();
                    formatter.Serialize(stream, memberList);
                }
            }
            catch(IOException IOEx)
            {
                throw new ApplicationException("Error! Can't write to file. Message: " + IOEx.ToString());
            }
        }

        //Loads and returns List<Members>
        public List<Member> Load()
        {
            List<Member> memberList;
            if (File.Exists(filePath))
            {
                using (Stream stream = File.Open(filePath, FileMode.Open))
                {
                    BinaryFormatter formatter = new BinaryFormatter();
                    memberList = (List<Member>)formatter.Deserialize(stream);
                }
                return memberList;
            }
            else
            {
                return new List<Member>();
            }
            
        }

    }
}
