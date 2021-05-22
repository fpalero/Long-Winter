package cards.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomCards {
  Integer totalCards = 48;
  List<Integer> randomNumbers;
  Deck deck;
  Integer position;

  public RandomCards(Deck deck) {
    this.randomNumbers = new ArrayList<>(totalCards);
    this.deck = deck;
    this.position = 0;
  }

  public void order() {
    this.randomNumbers.clear();
    position = 0;

    for (int i = 0; i < totalCards; i++) {
      this.randomNumbers.add(i);
    }
  }

  public void shuffle() {
    Collections.shuffle(this.randomNumbers);
  }

  public Card getCard() {
    if (this.position >= this.totalCards)
      return null;

    return this.deck.cards.get(
        this.randomNumbers.get(this.position++)
    );

  }
}
