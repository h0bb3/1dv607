using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.controller
{
	class Player
	{
		public bool PlayGame(view.Console a_view, model.GameFacade a_game)
		{
			a_view.PresentInstructions();
			a_view.DisplayHands(a_game.GetDealerHand(), a_game.GetDealerScore(), a_game.GetPlayerHand(), a_game.GetPlayerScore());
			if (a_game.IsGameOver())
			{
				a_view.DisplayWinner(a_game.IsPlayerWinner());
			}
			
			view.Console.Event e;

			e = a_view.GetEvent();
			if (e == view.Console.Event.Quit)
			{
				return false;
			}
			if (e == view.Console.Event.Start)
			{
				a_game.StartNewRound();
				
			}
			if (e == view.Console.Event.Hit)
			{
				a_game.Hit();
			}
			if (e == view.Console.Event.Stand)
			{
				a_game.Stand();
			}

			return true;
		}
	}
}
