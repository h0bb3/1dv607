using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Console
{
	class Program
	{
		static void Main(string[] args)
		{
			DiceGameModel.DiceGame g = new DiceGameModel.DiceGame();
			view.Console v = new view.EngConsole();
			controller.Player c = new controller.Player(v);

			c.PlayGame(g);
		}
	}
}
