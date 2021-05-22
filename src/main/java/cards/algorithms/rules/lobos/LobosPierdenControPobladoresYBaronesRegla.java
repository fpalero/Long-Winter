package cards.algorithms.rules.lobos;

import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.Rule;
import java.util.Map;

public class LobosPierdenControPobladoresYBaronesRegla extends Rule {
  @Override protected void runRule(Map<String, Party> parties, Card newEvent) {
    parties.get(CardType.LOBOS).fails++;
    parties.get(CardType.LOBOS).lastStatus = newEvent;
  }

  @Override protected boolean condition(Map<String, Party> parties, Card newEvent) {
    return newEvent.number < parties.get(CardType.BARONES).lastStatus.number &&
        newEvent.number < parties.get(CardType.POBLADORES).lastStatus.number;
  }
}
