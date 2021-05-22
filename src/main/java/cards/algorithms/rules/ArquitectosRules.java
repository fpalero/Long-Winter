package cards.algorithms.rules;

import cards.algorithms.rules.arquitectos.ArquitectosGananControPobladoresYBaronesRegla;
import cards.algorithms.rules.arquitectos.ArquitectosPierdenControPobladoresYBaronesRegla;
import cards.helpers.rules.Rule;
import cards.helpers.rules.RuleChecker;
import java.util.ArrayList;
import java.util.List;

public class ArquitectosRules {
  private static List<Rule> rules = new ArrayList<>();

  static {
    rules.add(new ArquitectosGananControPobladoresYBaronesRegla());
    rules.add(new ArquitectosPierdenControPobladoresYBaronesRegla());
  }

  public static List<Rule>  getRules() {
    return rules;
  }
}
