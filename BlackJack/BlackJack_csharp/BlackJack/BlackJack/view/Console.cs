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

		public void DisplayHands(IEnumerable<model.Card> a_dealerHand, int a_dealerScore, IEnumerable<model.Card> a_playerHand, int a_playerScore)
		{
			if (a_dealerHand.Count() > 0)
			{
				System.Console.WriteLine("Dealer has:");
				DisplayHand(a_dealerHand);
				System.Console.WriteLine("Dealer score: {0}", a_dealerScore);

			}

			if (a_playerHand.Count() > 0)
			{
				System.Console.WriteLine("\nPlayer has:");
				DisplayHand(a_playerHand);
				System.Console.WriteLine("Player score: {0}", a_playerScore);
			}
		}

		public void DisplayHand(IEnumerable<model.Card> a_hand)
		{

			foreach (model.Card c in a_hand)
			{
				System.Console.WriteLine("{0} of {1}", c.GetValue(), c.GetColor()); 
			}
		}

		public void DisplayWinner(bool a_isPlayerWinner)
		{
			if (a_isPlayerWinner)
			{
				System.Console.WriteLine("You Won!");
			}
			else
			{
				System.Console.WriteLine("You Lost!");
			}
		}

		public Event GetEvent()
		{
			char c = System.Console.ReadKey().KeyChar;
			if (c == 'q') {
				return Event.Quit;
			}
			if (c == 'h')
			{
				return Event.Hit;
			}
			if (c == 'p')
			{
				return Event.Start;
			}
			if (c == 's')
			{
				return Event.Stand;
			}

			return Event.None;
		}
	}
}
