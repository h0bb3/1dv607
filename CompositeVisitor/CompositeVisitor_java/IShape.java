public interface IShape {
  public float getArea();
  public void accept(IShapeVisitor a_visitor);
}