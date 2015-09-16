using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame.controller
{
	class Player
	{
		public void PlayGame(model.DiceGame a_game, view.Console a_view)
		{
			a_view.DisplayInstructions();

			while (a_view.WantsToPlay())
			{
				a_view.DisplayInstructions();

				a_view.DisplayResult(a_game.Play(), a_game.GetDice1Value(), a_game.GetDice2Value());
				
			}

		}
	}
}
