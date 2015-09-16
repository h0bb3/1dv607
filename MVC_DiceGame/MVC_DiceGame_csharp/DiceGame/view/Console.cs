using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame.view
{
	class Console
	{
        private char keyToExit = 'q';

		public void DisplayInstructions()
		{
			System.Console.Clear();
			String message = $"Welcome to the cool Dice Game. Press any Key to play, or { keyToExit } to Quit";
			System.Console.WriteLine(message);
		}

		public bool WantsToPlay()
		{
			return System.Console.ReadKey().KeyChar != keyToExit;
		}

		public char GetInput()
		{
			return System.Console.ReadKey().KeyChar;
		}

		public void DisplayResult(bool a_isWinner, int a_dice1Value, int a_dice2Value)
		{
			if (a_isWinner)
			{
				System.Console.WriteLine($"You are a winner: { a_dice1Value } { a_dice2Value }");
			}
			else
			{
				System.Console.WriteLine($"Sorry you lost: { a_dice1Value } { a_dice2Value }");
			}
		}
	}
}
