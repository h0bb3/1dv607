using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model.rules
{
	interface StartNewGameStrategy
	{
		void StartNewRound(Player a_player, Player a_dealer, Deck a_deck);
	}
}
