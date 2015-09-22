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
			view.Console v = new view.Console();
			v.PresentInstructions();
		}
	}
}
