package cards.algorithms.rules.arquitectos;

import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.Rule;
import java.util.Map;

public class ArquitectosPierdenControPobladoresYBaronesRegla extends Rule {
  @Override protected void runRule(Map<String, Party> parties, Card newEvent) {
    parties.get(CardType.ARQUITECTOS).fails++;
    parties.get(CardType.ARQUITECTOS).lastStatus = newEvent;
  }

  @Override protected boolean condition(Map<String, Party> parties, Card newEvent) {
    return newEvent.number < parties.get(CardType.BARONES).lastStatus.number &&
        newEvent.number < parties.get(CardType.POBLADORES).lastStatus.number;
  }
}
