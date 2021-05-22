package cards.algorithms.rules.pobladores;

import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.Rule;
import java.util.Map;

public class PobladoresGananContraDosGruposRegla extends Rule {
  @Override protected void runRule(Map<String, Party> parties, Card newEvent) {
    parties.get(CardType.POBLADORES).fails =
        Math.max(0, parties.get(CardType.POBLADORES).fails--);
    parties.get(CardType.POBLADORES).success++;
    parties.get(CardType.POBLADORES).lastStatus = newEvent;
  }

  @Override protected boolean condition(Map<String, Party> parties, Card newEvent) {
    return boronesYotroGrupoPierden(parties, newEvent);
  }

  private boolean boronesYotroGrupoPierden(Map<String, Party> parties, Card newEvent) {
    return (newEvent.number > parties.get(CardType.LOBOS).lastStatus.number ||
        newEvent.number > parties.get(CardType.ARQUITECTOS).lastStatus.number) &&
        newEvent.number > parties.get(CardType.BARONES).lastStatus.number;
  }
}
