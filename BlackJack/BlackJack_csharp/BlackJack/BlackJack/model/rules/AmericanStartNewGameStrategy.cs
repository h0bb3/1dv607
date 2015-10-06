using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model.rules
{
	partial class ConcreteRules {
		private class AmericanStartNewGameStrategy : StartNewGameStrategy
		{
			public void StartNewRound(Player a_player, Player a_dealer, Deck a_deck)
			{
				Card c = a_deck.GetCard();
				c.Show();
				a_player.DealCard(c);

				c = a_deck.GetCard();
				c.Show();
				a_dealer.DealCard(c);

				c = a_deck.GetCard();
				c.Show();
				a_player.DealCard(c);

				c = a_deck.GetCard();
				a_dealer.DealCard(c);
			}
		}
	}
}
