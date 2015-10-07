using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	class Rectangle : Shape
	{
		float m_width, m_height;

		public Rectangle(float a_width, float a_height)
		{
			m_width = a_width;
			m_height = a_height;
		}

		public float GetArea() {
			return m_width * m_height;
		}

		public void Accept(ShapeVisitor a_visitor)
		{
			a_visitor.VisitRectangle(this);
		}
	}
}
