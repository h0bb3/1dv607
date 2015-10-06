using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model.rules
{

	partial class ConcreteRules
	{
		public class RuleFactory
		{
			public StartNewGameStrategy GetStartNewGameRule()
			{
				// more advanced code to decide what rule to create
				// for example reading from a file
				return new AmericanStartNewGameStrategy();
			}
		}
	}
}
