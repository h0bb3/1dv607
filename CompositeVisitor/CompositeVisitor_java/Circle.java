public class Circle implements IShape {
  
  private float m_radius;
  
  public Circle(float a_rad) {
    m_radius = a_rad;
  }
  
  public float getArea() {
    return m_radius * m_radius * 3.1415f; 
  }
  
  public void accept(IShapeVisitor a_visitor) {
    a_visitor.visitCircle(this);
  }
}