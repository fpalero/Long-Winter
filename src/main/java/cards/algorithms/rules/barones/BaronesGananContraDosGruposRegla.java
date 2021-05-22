package cards.algorithms.rules.barones;

import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.Rule;
import java.util.Map;

public class BaronesGananContraDosGruposRegla extends Rule {
  @Override protected void runRule(Map<String, Party> parties, Card newEvent) {
    parties.get(CardType.BARONES).fails =
        Math.max(0, parties.get(CardType.BARONES).fails--);
    parties.get(CardType.BARONES).success++;
    parties.get(CardType.BARONES).lastStatus = newEvent;
  }

  @Override protected boolean condition(Map<String, Party> parties, Card newEvent) {
    return pobladoresYotroGrupoPierden(parties, newEvent);
  }

  private boolean pobladoresYotroGrupoPierden(Map<String, Party> parties, Card newEvent) {
    return (newEvent.number > parties.get(CardType.LOBOS).lastStatus.number ||
        newEvent.number > parties.get(CardType.ARQUITECTOS).lastStatus.number) &&
        newEvent.number > parties.get(CardType.POBLADORES).lastStatus.number;
  }
}
