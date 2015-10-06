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
			Count,
			Hidden
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
			Count,
			Hidden,
		}

		Color m_color;
		Value m_value;
		bool m_isHidden; 

		public Card(Color a_color, Value a_value)
		{
			m_color = a_color;
			m_value = a_value;
			m_isHidden = true;
		}

		public void Show(bool a_doShow = true)
		{
			m_isHidden = !a_doShow;
		}

		public Color GetColor()
		{
			if (m_isHidden) {
				return Color.Hidden;
			}
			return m_color;
		}

		public Value GetValue()
		{
			if (m_isHidden) {
				return Value.Hidden;
			}
			return m_value;
		}

	}
}
