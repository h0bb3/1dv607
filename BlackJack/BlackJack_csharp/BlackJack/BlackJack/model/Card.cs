using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack.model
{
	class Card
	{
		public enum Color {
			Hearts,
			Clubs,
			Diamonds,
			Spades,
			Count
		}

		public enum Value {
			Two,
			Three,
			Four,
			Five,
			Six,
			Seven,
			Eight,
			Nine,
			Ten,
			Knight,
			Queen,
			King,
			Ace,
			Count
		}

		Color m_color;
		Value m_value;

		public Card(Color a_color, Value a_value)
		{
			m_color = a_color;
			m_value = a_value;
		}

		public Color GetColor()
		{
			return m_color;
		}

		public Value GetValue()
		{
			return m_value;
		}

	}
}
