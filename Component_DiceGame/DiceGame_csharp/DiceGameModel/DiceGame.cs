using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGameModel
{
	public class DiceGame
	{
		Dice m_d1;
		Dice m_d2;

		List<DiceGameObserver> m_observers;

		public DiceGame()
		{
			m_d1 = new Dice();
			m_d2 = new Dice();
			m_observers = new List<DiceGameObserver>();
		}

		public void AddSubscriber(DiceGameObserver a_sub)
		{
			m_observers.Add(a_sub);
		}

		private void RollDice(Dice a_dice) {
			a_dice.Roll();
			foreach (DiceGameObserver o in m_observers) {
				o.DiceRolled(a_dice.GetValue());
			}
		}

		public bool Play()
		{

			RollDice(m_d1);
			System.Threading.Thread.Sleep(2000);
			RollDice(m_d2);

			return m_d1.GetValue() + m_d2.GetValue() == 7;
		}
	}
}
