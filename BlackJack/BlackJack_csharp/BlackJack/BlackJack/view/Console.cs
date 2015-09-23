using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.view
{
	class Console
	{
		public enum Event {
			None,
			Start,
			Hit,
			Stand,
			Quit
		}

		public void PresentInstructions()
		{
			System.Console.Clear();
			System.Console.WriteLine("Welcome to uber the BlackJack Game");
			System.Console.WriteLine("p to play, h to hit, s to stand, q  to quit");
		}

		public void DisplayHands(IEnumerable<model.Card> a_dealerHand, IEnumerable<model.Card> a_playerHand)
		{
			if (a_dealerHand.Count() > 0)
			{
				System.Console.WriteLine("Dealer has:");
				DisplayHand(a_dealerHand);
			}

			if (a_playerHand.Count() > 0)
			{
				System.Console.WriteLine("\nPlayer has:");
				DisplayHand(a_playerHand);
			}
		}

		public void DisplayHand(IEnumerable<model.Card> a_hand)
		{

			foreach (model.Card c in a_hand)
			{
				System.Console.WriteLine("{0} of {1}", c.GetValue(), c.GetColor()); 
			}
		}

		public Event GetEvent()
		{
			char c = System.Console.ReadKey().KeyChar;
			if (c == 'q') {
				return Event.Quit;
			}
			if (c == 'p')
			{
				return Event.Start;
			}

			return Event.None;
		}
	}
}
