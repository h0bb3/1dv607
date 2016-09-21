package model;

public class Card {
  
  public enum Color {
    Hearts,
    Spades,
    Diamonds,
    Clubs,
    Count
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
    Count
  }
  
  private Color m_color;
  private Value m_value;
  
  public Card(Color a_color, Value a_value) {
    m_color = a_color;
    m_value = a_value;
  }
  
  public Color getColor() {
    return m_color;
  }
  
  public Value getValue() {
    return m_value;
  }
}