using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class Deck
	{
		List<Card> m_cards;
		Random r = new Random();

		public Deck()
		{
			m_cards = new List<Card>();

			for (int color = 0; color < (int)Card.Color.Count; color++)
			{
				for (int value = 0; value < (int)Card.Value.Count; value++)
				{
					Card c = new Card((Card.Color)color, (Card.Value)value);
					Add(c);
				}
			}
		}

		public Card GetCard()
		{
			Card c = m_cards.ElementAt(0);
			m_cards.RemoveAt(0);
			return c;
		}

		public void Add(Card a_card) {
			m_cards.Add(a_card);
		}

		public void Shuffle()
		{
			Random r = new Random();
			for (int i = 0; i < 1000; i++)
			{
				int ix = r.Next(m_cards.Count);
				Card c = m_cards.ElementAt(ix);
				m_cards.RemoveAt(ix);
				Add(c);
			}
		}
	}
}
