using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame
{
	class DiceGame
	{
		Dice m_d1;
		Dice m_d2;

		public DiceGame()
		{
			m_d1 = new Dice();
			m_d2 = new Dice();
		}

		public bool Play()
		{
			m_d1.Roll();
			m_d2.Roll();
			return m_d1.GetValue() + m_d2.GetValue() == 7;
		}
	}
}
