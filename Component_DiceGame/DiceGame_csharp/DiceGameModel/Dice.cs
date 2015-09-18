using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGameModel
{
	class Dice
	{
		private int m_value;

		private static System.Random g_random = new System.Random(); // implementation detail

		public Dice()
		{
			m_value = 0;
		}

		public void Roll()
		{
			m_value = g_random.Next(1, 7);
		}

		public int GetValue() {
			return m_value;	
		}
	}
}
