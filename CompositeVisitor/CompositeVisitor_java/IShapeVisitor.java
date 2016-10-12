public interface IShapeVisitor {

  public void visitRectangle(Rectangle a_rect);
  public void visitCircle(Circle a_circle);
  public void visitCompositePre(CompositeShape a_group);
  public void visitCompositePost(CompositeShape a_group);
}