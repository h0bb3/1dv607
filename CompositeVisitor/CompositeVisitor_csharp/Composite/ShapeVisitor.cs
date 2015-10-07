using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	interface ShapeVisitor
	{
		void VisitRectangle(Rectangle a_rect);
		void VisitCircle(Circle a_circle);
		void VisitComposite(CompositeShapeAdd a_composite);
	}
}
