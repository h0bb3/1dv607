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
			view.Console v = new view.SweConsole();
			controller.Player c = new controller.Player(v);

			c.PlayGame(g);
		}
	}
}
