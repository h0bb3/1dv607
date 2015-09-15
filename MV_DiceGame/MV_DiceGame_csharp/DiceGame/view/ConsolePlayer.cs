using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame.view
{
	class ConsolePlayer
	{
		public void Play(model.DiceGame a_game)
		{
			String message = "Welcome to the cool Dice Game. Press any Key to play, or q to Quit";


			System.Console.WriteLine(message);

			while (System.Console.ReadKey().KeyChar != 'q')
			{
				System.Console.Clear();
				System.Console.WriteLine(message);
				if (a_game.Play())
				{
					System.Console.WriteLine("You are a winner: {0} {1}", a_game.GetDice1Value(), a_game.GetDice2Value());
				}
				else
				{
					System.Console.WriteLine("Sorry you lost: {0} {1}", a_game.GetDice1Value(), a_game.GetDice2Value());
				}
			}
		}
	}
}
