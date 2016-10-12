public class Program {

  public static void main(String[] a_args) {
    IShape c = new Circle(5.0f);
    IShape r = new Rectangle(5, 10);
    CompositeShape comp = new CompositeShape();
    
    printArea(c);
    printArea(r);
    
    comp.add(c);
    comp.add(r);
    
    printArea(comp);
    
    ShapePrinterVisitor v = new ShapePrinterVisitor();
    
    comp.accept(v);
  }
  
  public static void printArea(IShape a_shape) {
    System.out.println("Area is: " + a_shape.getArea());
  }
}