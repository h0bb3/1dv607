using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class GameFacade
	{
		Dealer m_dealer;
		Player m_player;

		public GameFacade()
		{
			m_dealer = new Dealer(new rules.ConcreteRules.RuleFactory());
			m_player = new Player();
		}

		public void StartNewRound()
		{
			m_dealer.StartNewRound(m_player);
		}

		public void Hit()
		{
			m_dealer.HitPlayer(m_player);
		}

		public void Stand()
		{
			m_dealer.Stand();
		}

		public IEnumerable<Card> GetDealerHand()
		{
			return m_dealer.GetHand();
		}

		public IEnumerable<Card> GetPlayerHand()
		{
			return m_player.GetHand();
		}

		public int GetDealerScore()
		{
			return m_dealer.GetScoreOfHand();
		}

		public int GetPlayerScore()
		{
			return m_player.GetScoreOfHand();
		}

		public bool IsPlayerWinner()
		{
			return m_dealer.IsPlayerWinner(m_player);
		}

		public bool IsGameOver()
		{
			return m_dealer.IsGameOver();
		}
	}
}
