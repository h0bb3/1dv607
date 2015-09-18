using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame.view
{
	class SweConsole : Console
	{
		override public void DisplayInstructions()
		{
			System.Console.Clear();
			String message = "Välkommen till tärningsspelet. Tryck en tangent för att spela, eller s för att sluta";
			System.Console.WriteLine(message);
		}

		override public bool WantsToPlay()
		{
			return System.Console.ReadKey().KeyChar != 's';
		}

		override public void DisplayResult(bool a_isWinner)
		{
			if (a_isWinner)
			{
				System.Console.WriteLine("Du är en vinnare!");
			}
			else
			{
				System.Console.WriteLine("Ledsen men du förlorade!");
			}
		}
	}
}
