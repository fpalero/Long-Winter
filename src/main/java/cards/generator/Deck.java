package cards.generator;

import java.util.ArrayList;
import java.util.List;

public class Deck {
  public List<Card> cards;

  public Deck() {
    this.cards = new ArrayList<>();

    int i = 0;
    // Rellenar corazones
    for (; i < 12; i++) {
      this.cards.add(i,
          new Card(CardType.ARQUITECTOS, i%12));
    }

    // rellenar picas
    for (; i < 24; i++) {
      this.cards.add(i,
          new Card(CardType.LOBOS, i%12));
    }

    // rellenar trevoles
    for (; i < 36; i++) {
      this.cards.add(i,
          new Card(CardType.POBLADORES, i%12));
    }

    // rellenar diamantes
    for (; i < 48; i++) {
      this.cards.add(i,
          new Card(CardType.BARONES, i%12));
    }
  }
}
