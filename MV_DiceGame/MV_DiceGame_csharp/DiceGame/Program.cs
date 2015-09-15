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
			model.DiceGame g = new model.DiceGame();
			view.ConsolePlayer p = new view.ConsolePlayer();

			p.Play(g);
		}
	}
}
