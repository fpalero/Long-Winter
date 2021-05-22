package cards.algorithms.rules;

import cards.algorithms.rules.lobos.LobosGananControPobladoresYBaronesRegla;
import cards.algorithms.rules.lobos.LobosPierdenControPobladoresYBaronesRegla;
import cards.helpers.rules.Rule;
import java.util.ArrayList;
import java.util.List;

public class LobosRules {
  private static List<Rule> rules = new ArrayList<>();

  static {
    rules.add(new LobosGananControPobladoresYBaronesRegla());
    rules.add(new LobosPierdenControPobladoresYBaronesRegla());
  }

  public static List<Rule>  getRules() {
    return rules;
  }
}
