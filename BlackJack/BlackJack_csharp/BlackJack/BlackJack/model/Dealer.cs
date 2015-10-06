using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class Dealer : Player
	{
		private Deck m_deck;
		private rules.StartNewGameStrategy m_startGameRule;

		public Dealer(rules.ConcreteRules.RuleFactory a_rules)
		{
			m_deck = null;
			m_startGameRule = a_rules.GetStartNewGameRule();
			//m_startGameRule = new rules.EuroStartNewGameStrategy();
		}

		public void StartNewRound(Player a_player)
		{
			if (m_deck == null)
			{
				m_deck = new Deck();
				m_startGameRule.StartNewRound(a_player, this, m_deck);
			}
		}

		public void Stand()
		{
			if (m_deck != null)
			{
				ShowHand();
				while (GetScoreOfHand() <= 16)
				{
					Card c = m_deck.GetCard();
					c.Show();
					DealCard(c);
				}

				m_deck = null;
			}
		}

		public bool IsGameOver()
		{
			return m_deck == null && GetScoreOfHand() > 0;
		}

		public bool IsPlayerWinner(Player a_player)
		{
			int myScore = GetScoreOfHand();
			int playerScore = a_player.GetScoreOfHand();

			if (playerScore > 21)
			{
				return false;
			}
			if (myScore > 21)
			{
				return true;
			}

			if (playerScore >= myScore)
			{
				return true;
			}

			return false;
		}

		public void HitPlayer(Player a_player)
		{
			if (m_deck != null && a_player.GetScoreOfHand() < 21)
			{
				Card c = m_deck.GetCard();
				c.Show();
				a_player.DealCard(c);
			}
		}
	}
}
