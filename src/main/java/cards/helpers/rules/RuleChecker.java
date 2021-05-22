package cards.helpers.rules;

import cards.generator.Card;
import cards.helpers.parties.Party;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleChecker {
  List<Rule> rules;

  public RuleChecker(List<Rule> rules) {
    this.rules = rules;
  }

  public void check(Map<String, Party> currentStatus, Card newEvent) {
    Iterator<Rule> rulesIterator = rules.iterator();
    Rule rule = null;

    // Busca la regla relacionada con el nuevo event.
    // Solo se aplica una regla cada vez, aunque pudieran exister 2 reglas que se ajusten al
    // evento, por eso motivo el orden en que se insertan las reglas en la list es importante.
    // También puede existir el caso que ninguna regla se aplique.
    do {
       rule = rulesIterator.next();
       rule.apply(currentStatus, newEvent);
    } while(!rule.isApplied() && rulesIterator.hasNext());
  }
}
