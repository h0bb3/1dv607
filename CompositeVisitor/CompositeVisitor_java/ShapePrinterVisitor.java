public class ShapePrinterVisitor implements IShapeVisitor {
  private int m_tabCount;
  
  public ShapePrinterVisitor() {
    m_tabCount = 0;
  }
  
  private void printTabs() {
    for (int i = 0; i < m_tabCount; i++) {
      System.out.print("\t");
    }
  }
  
  public void visitRectangle(Rectangle a_rect) {
    printTabs();
    System.out.println("Rectanlge Area: " + a_rect.getArea());
  }
  
  public void visitCircle(Circle a_circle) {
    printTabs();
    System.out.println("Circle Area: " + a_circle.getArea());
  }
  
  public void visitCompositePre(CompositeShape a_group) {
    printTabs();
    System.out.println("Composite Total Area: " + a_group.getArea());
    System.out.println("Composite parts: ");
    m_tabCount++;
  }
  
  public void visitCompositePost(CompositeShape a_group) {
    m_tabCount--;
  }
    
}