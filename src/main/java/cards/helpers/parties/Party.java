package cards.helpers.parties;

import cards.generator.Card;
import cards.helpers.rules.RuleChecker;

public class Party {
  private RuleChecker ruleChecker;
  public double success;
  public double fails;
  public Card lastStatus;

  public Party() {
    this(null);
  }

  public Party(Card card) {
    this.success = 0;
    this.fails = 0;
    this.lastStatus = card;
  }
}
