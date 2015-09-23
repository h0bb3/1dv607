using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class Dealer
	{
		private Deck m_deck;
		List<Card> m_hand;


		public Dealer()
		{
			m_hand = new List<Card>();
			m_deck = new Deck();
			m_deck.Shuffle();
		}

		public void StartNewRound(Player a_player)
		{
			Card c = m_deck.GetCard();
			c.Show();
			a_player.DealCard(c);

			c = m_deck.GetCard();
			c.Show();
			DealCard(c);

			c = m_deck.GetCard();
			c.Show();
			a_player.DealCard(c);

			c = m_deck.GetCard();
			DealCard(c);
		}

		public void DealCard(Card a_card)
		{
			m_hand.Add(a_card);
		}

		public  IEnumerable<Card> GetHand()
		{
			return (IEnumerable<Card>)m_hand.AsEnumerable();
		}
	}
}
