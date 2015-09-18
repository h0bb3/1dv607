using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame.controller
{
	class Player : model.DiceGameObserver
	{
		view.Console m_view;

		public Player(view.Console a_view)
		{
			m_view = a_view;
		}

		public void PlayGame(model.DiceGame a_game)
		{
			a_game.AddSubscriber(this);
			m_view.DisplayInstructions();

			while (m_view.WantsToPlay())
			{
				m_view.DisplayInstructions();

				m_view.DisplayResult(a_game.Play());
				
			}

		}

		public void DiceRolled(int a_faceValue)
		{
			m_view.DisplayDiceValue(a_faceValue);
		}
	}
}
