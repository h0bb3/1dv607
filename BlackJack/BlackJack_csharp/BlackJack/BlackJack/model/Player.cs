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

		public void DealCard(Card a_card)
		{
			m_hand.Add(a_card);
		}

		public IEnumerable<Card> GetHand()
		{
			return (IEnumerable<Card>)m_hand.AsEnumerable();
		}

		public void ClearHand()
		{
			m_hand.Clear();
		}

		public void ShowHand()
		{

			foreach (Card c in GetHand())
			{
				c.Show();
			}
		}

		public int GetScoreOfHand()
		{
			int[] points = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };	// Specific for black jack
			int score = 0;

			foreach (Card c in GetHand())
			{
				if (c.GetColor() != Card.Color.Hidden)
				{
					score += points[(int)c.GetValue()];
				}
			}

			if (score > 21)
			{
				foreach (Card c in GetHand())
				{
					if (c.GetValue() == Card.Value.Ace)
					{
						score -= 10;
						if (score <= 21)
						{
							break;
						}
					}
				}
			}


			return score;
		}
	}
}
