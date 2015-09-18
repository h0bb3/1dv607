using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGameModel
{
	public interface DiceGameObserver
	{
		void DiceRolled(int a_faceValue);
	}
}
