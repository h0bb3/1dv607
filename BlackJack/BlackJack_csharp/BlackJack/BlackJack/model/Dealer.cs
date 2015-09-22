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

		public Dealer()
		{
			m_deck = new Deck();
			m_deck.Shuffle();
		}
	}
}
