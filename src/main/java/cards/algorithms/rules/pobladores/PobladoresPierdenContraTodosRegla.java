package cards.algorithms.rules.pobladores;

import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.Rule;
import java.util.Map;

public class PobladoresPierdenContraTodosRegla extends Rule {
  @Override protected void runRule(Map<String, Party> parties, Card newEvent) {
    parties.get(CardType.ARQUITECTOS).success++;
    parties.get(CardType.LOBOS).success++;
    parties.get(CardType.POBLADORES).lastStatus = newEvent;
  }

  @Override protected boolean condition(Map<String, Party> parties, Card newEvent) {
    return newEvent.number < parties.get(CardType.LOBOS).lastStatus.number &&
        newEvent.number < parties.get(CardType.ARQUITECTOS).lastStatus.number &&
        newEvent.number < parties.get(CardType.BARONES).lastStatus.number;
  }
}
