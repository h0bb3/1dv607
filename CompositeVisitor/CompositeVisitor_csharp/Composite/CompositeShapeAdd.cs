using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	class CompositeShapeAdd : Shape
	{
		List<Shape> m_shapes;

		public CompositeShapeAdd()
		{
			m_shapes = new List<Shape>();
		}

		public void Add(Shape a_child) {
			m_shapes.Add(a_child);
		}

		public float GetArea()
		{
			float totalArea = 0;

			foreach(Shape s in m_shapes) {
				totalArea += s.GetArea();
			}

			return totalArea;
		}

		public void Accept(ShapeVisitor a_visitor)
		{
			a_visitor.VisitComposite(this);
			foreach (Shape s in m_shapes)
			{
				s.Accept(a_visitor);
			}
		}
	}
}
