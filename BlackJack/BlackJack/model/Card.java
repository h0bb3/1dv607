package model;

public class Card {
  
  public enum Color {
    Hearts,
    Spades,
    Diamonds,
    Clubs,
    Count,
    Hidden
  }
  
  public enum Value {
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Knight,
    Queen,
    King,
    Ace,
    Count,
    Hidden
  }
  
  private Color m_color;
  private Value m_value;
  private boolean m_isHidden;
  
  public Card(Color a_color, Value a_value) {
    m_color = a_color;
    m_value = a_value;
    m_isHidden = true;
  }
  
  public void show() {
    m_isHidden = false;
  }
  
  public Color getColor() {
    if (m_isHidden) {
      return Color.Hidden;
    }
    return m_color;
  }
  
  public Value getValue() {
    if (m_isHidden) {
      return Value.Hidden;
    }
    return m_value;
  }
}