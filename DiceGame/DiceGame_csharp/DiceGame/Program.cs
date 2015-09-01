using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiceGame
{
	class Program
	{
		static void Main(string[] args)
		{
			DiceGame g = new DiceGame();

			if (g.Play())
			{
				System.Console.WriteLine("You are a winner");
			}
			else
			{
				System.Console.WriteLine("Sorry");
			}
		}
	}
}
