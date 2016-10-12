public class CompositeShape implements IShape {
  java.util.LinkedList<IShape> m_shapes;
  
  public CompositeShape() {
    m_shapes = new java.util.LinkedList<IShape>();
  }
  
  public void add(IShape a_shape) {
    m_shapes.add(a_shape);
  }
  
  public float getArea() {
    float total = 0;
    
    for(IShape s : m_shapes) {
      total += s.getArea();
    }
    
    return total;
  }
  
  public void accept(IShapeVisitor a_visitor) {
    a_visitor.visitCompositePre(this);
    for(IShape s : m_shapes) {
      s.accept(a_visitor);
    }
    a_visitor.visitCompositePost(this);
  }
}