using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Console.view
{
	class EngConsole : Console
	{

		override public void DisplayInstructions()
		{
			System.Console.Clear();
			String message = "Welcome to the cool Dice Game. Press any Key to play, or q to Quit";
			System.Console.WriteLine(message);
		}

		override public bool WantsToPlay()
		{
			return System.Console.ReadKey().KeyChar != 'q';
		}

		override public void DisplayResult(bool a_isWinner)
		{
			if (a_isWinner)
			{
				System.Console.WriteLine("You are a winner!");
			}
			else
			{
				System.Console.WriteLine("Sorry you lost!");
			}
		}
	}
}
