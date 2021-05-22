package cards.helpers.rules;

import cards.generator.Card;
import cards.helpers.parties.Party;
import java.util.Map;

public abstract class Rule {
  private boolean isApplied;
  public void apply(Map<String, Party> parties, Card newEvent) {
    // Guardar si es posible aplicar la regla
    this.isApplied = this.condition(parties, newEvent);

    // Si es posible entonces se aplica la regla y se modifica el estado de la facción
    if(this.isApplied)
      runRule(parties, newEvent);
  }

  protected abstract void runRule(Map<String, Party> parties, Card newEvent);

  protected abstract boolean condition(Map<String, Party> parties, Card newEvent);

  public boolean isApplied() {
    return this.isApplied;
  }
}
