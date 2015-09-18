using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Console.view
{
	abstract class Console
	{
		abstract public void DisplayInstructions();

		public void DisplayDiceValue(int a_faceValue)
		{
			System.Console.WriteLine("{0}", a_faceValue);
		}

		abstract public bool WantsToPlay();

		public char GetInput()
		{
			return System.Console.ReadKey().KeyChar;
		}

		abstract public void DisplayResult(bool a_isWinner);
	}
}
