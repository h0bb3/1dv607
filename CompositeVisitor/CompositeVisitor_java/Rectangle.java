public class Rectangle implements IShape {
  
 private float m_w, m_h;
 
 public Rectangle(float a_w, float a_h) {
   m_w = a_w;
   m_h = a_h;
 }
  
  public float getArea() {
    return m_w * m_h;
  }
  
  public void accept(IShapeVisitor a_visitor) {
    a_visitor.visitRectangle(this);
  }
}