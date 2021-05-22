package cards.generator;

public class Card {
  public Card(String type, double number) {
    this.type = type;
    this.number = number;
  }

  public String type;
  public double number;

  @Override public String toString() {
    return String.format("type: %s, number %d\n", this.type, this.number);
  }
}
