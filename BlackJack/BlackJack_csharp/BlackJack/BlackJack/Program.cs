using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack
{
	class Program
	{
		static void Main(string[] args)
		{
			model.Dealer d = new model.Dealer();
			model.Player p = new model.Player();
			view.Console v = new view.Console();
			controller.Player c = new controller.Player();


			while (c.PlayGame(v, d, p)) ;
		}
	}
}
