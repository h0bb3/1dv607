using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	class Circle : Shape
	{
		float m_radius;

		public Circle(float a_radius)
		{
			m_radius = a_radius;
		}

		public float GetArea()
		{
			return m_radius * m_radius * (float)Math.PI;
		}

		public void Accept(ShapeVisitor a_visitor)
		{
			a_visitor.VisitCircle(this);
		}
	}
}
