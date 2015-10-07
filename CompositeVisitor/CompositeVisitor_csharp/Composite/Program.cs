using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Composite
{
	class Program
	{
		static void Main(string[] args)
		{
			Shape rect = new Rectangle(2, 5);
			Shape circle = new Circle(2);
			CompositeShapeAdd c = new CompositeShapeAdd();

			c.Add(rect);
			c.Add(circle);

			PrintArea(c);
		}

		static void PrintArea(Shape a_shape) {
			ShapeVisitor v = new ConsolePrintShapeVisitor();

			a_shape.Accept(v);

			System.Console.WriteLine("Area is: {0}", a_shape.GetArea());
		}
	}

	class ConsolePrintShapeVisitor : ShapeVisitor
	{
		public void VisitRectangle(Rectangle a_rect)
		{
			System.Console.WriteLine("Rectanlge");
		}
		public void VisitCircle(Circle a_circle)
		{
			System.Console.WriteLine("Circle");
		}
		public void VisitComposite(CompositeShapeAdd a_composite)
		{
			System.Console.WriteLine("Group Consisting of: ");
		}
	}
}
