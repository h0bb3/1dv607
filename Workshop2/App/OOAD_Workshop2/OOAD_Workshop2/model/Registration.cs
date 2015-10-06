using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OOAD_Workshop2.model
{
    public class Registration
    {
        
        private List<Member> members;
        private IRegistrationDAL db;

        /// <summary>
        /// 
        /// </summary>
        /// <param name="regDAL">Data access layer</param>
        public Registration(IRegistrationDAL regDAL)
        {
            db = regDAL;
            members = new List<Member>();
            members = db.Load();
        }

        /// <summary>
        /// Saves List(Members) to varible and to persistent media
        /// </summary>
        /// <param name="member"></param>
        public void Save(Member member)
        {
            member.UniqueId = generateUniqueMemberId();
            members.Add(member);
            db.Save((List<Member>)members);
        }

        /// <summary>
        /// Fetches and returns a List of members
        /// </summary>
        /// <returns>List(Members)</returns>
        public List<Member> Load() 
        {
            return db.Load();
        }

        /// <summary>
        /// Checks for a unique id in list members and returns 1 int higher
        /// </summary>
        /// <returns></returns>
        private int generateUniqueMemberId()
        {
            if(members.Count == 0)
            {
                return 1;
            }

            int highestId = members.Max(mem => mem.UniqueId);
            return highestId + 1; 
        }

        /// <summary>
        /// Checks for a unique id in list Boats and returns 1 int higher
        /// </summary>
        /// <param name="selectedMember"></param>
        /// <returns></returns>
        private int generateUniqueBoatId(Member selectedMember)
        {
            if (selectedMember.Boats.Count < 1)
            {
                return 1;
            }

            //resets id, starting on 1 and increses with 1
            orderBoatId(selectedMember);

            int highestId = selectedMember.Boats.Max(id => id.Id);
            return highestId + 1;
        }

        private void orderBoatId(Member selectedMember)
        {
            int tmp = 1;
            foreach (Boat boat in selectedMember.Boats)
            {
                boat.Id = tmp;
                tmp++;
            }
        }

        
        public IEnumerable<Member> GetListOfMembers()
        {
            return members;
        }

        /// <summary>
        /// returns specific information of members
        /// </summary>
        /// <param name="memberId"></param>
        /// <returns></returns>
        public Member GetMemberInformation(int memberId)
        {
            Member member = (from mem in members
                             where mem.UniqueId == memberId
                             select mem).FirstOrDefault();
            if (member == null)
            {
                throw new ApplicationException("No member with that Id");
            }
            

            return member;
        }


        public void DeleteMember(Member toBeDeleted)
        {
            var member = (from mem in members
                       where mem.UniqueId == toBeDeleted.UniqueId
                       select mem).FirstOrDefault();

            members.Remove(member);
            db.Save((List<Member>)members);
        }

        public void UpdateMember(Member toBeUpdated)
        {
            var member = (from mem in members
                       where mem.UniqueId == toBeUpdated.UniqueId
                       select mem).FirstOrDefault();

            toBeUpdated.Name = member.Name;
            toBeUpdated.PersonalNumber = member.PersonalNumber;
            db.Save((List<Member>)members);
        }

        public void AddBoat(Member addToMember, Boat boat)
        {
            var member = (from mem in members
                          where mem.UniqueId == addToMember.UniqueId
                          select mem).FirstOrDefault();
            boat.Id = generateUniqueBoatId(addToMember);

            member.Boats.Add(boat);
            db.Save((List<Member>)members);
        }

        public void DeleteBoat(Member deleteFromMember, Boat toBeDeleted)
        {
            var delBoat = (from boat in deleteFromMember.Boats
                        where boat.Id == toBeDeleted.Id
                        select boat).FirstOrDefault();

            deleteFromMember.Boats.Remove(delBoat);
            //Rearange id starting from 1 and increasing by 1
            orderBoatId(deleteFromMember);
            db.Save((List<Member>)members);
        }

        public void UpdateBoat(Member updateFromMember, Boat toBeUpdated, BoatType type, float length)
        {
            var updateBoat = (from boat in updateFromMember.Boats
                              where boat.Id == toBeUpdated.Id
                              select boat).FirstOrDefault();

            //updateFromMember.Boats.Remove(updateBoat);

            
            
            DeleteBoat(updateFromMember, toBeUpdated);
            toBeUpdated.BoatType = type;
            toBeUpdated.Length = length;
            AddBoat(updateFromMember, toBeUpdated);

            //db.Save((List<Member>)members);
        }

    }
}
