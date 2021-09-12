public class Die {
  private int value;

  public Die() {
    roll();
  }

  public int getValue() {
    return value;
  }

  public void roll() {
    value = (int)(Math.random() * 6.0) + 1;
  }
}
