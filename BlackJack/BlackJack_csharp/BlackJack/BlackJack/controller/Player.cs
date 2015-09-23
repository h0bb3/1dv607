using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.controller
{
	class Player
	{
		public bool PlayGame(view.Console a_view, model.Dealer a_dealer, model.Player a_player)
		{
			a_view.PresentInstructions();
			a_view.DisplayHands(a_dealer.GetHand(), a_player.GetHand());
			view.Console.Event e;

			e = a_view.GetEvent();
			if (e == view.Console.Event.Quit)
			{
				return false;
			}
			if (e == view.Console.Event.Start)
			{
				a_dealer.StartNewRound(a_player);
				
			}

			return true;
		}
	}
}
