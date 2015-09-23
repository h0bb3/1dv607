using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class Player
	{
		List<Card> m_hand;


		public Player()
		{
			m_hand = new List<Card>();
		}

		public void DealCard(Card a_card) {
			m_hand.Add(a_card);
		}

		public IEnumerable<Card> GetHand()
		{
			return (IEnumerable<Card>)m_hand.AsEnumerable();
		}
	}
}
