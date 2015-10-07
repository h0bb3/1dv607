using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	interface Shape
	{
		float GetArea();
		void Accept(ShapeVisitor a_visitor);
	}
}
