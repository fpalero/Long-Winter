package cards.algorithms.rules;

import cards.algorithms.rules.barones.BaronesGananContraDosGruposRegla;
import cards.algorithms.rules.barones.BaronesGananContraPobladoresRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraDosGruposRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraPobladoresRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraTodosRegla;
import cards.helpers.rules.Rule;
import java.util.ArrayList;
import java.util.List;

public class BaronesRules {
  private static List<Rule> rules = new ArrayList<>();

  static {
    rules.add(new BaronesPierdenContraTodosRegla());
    rules.add(new BaronesPierdenContraDosGruposRegla());
    rules.add(new BaronesGananContraDosGruposRegla());
    rules.add(new BaronesGananContraPobladoresRegla());
    rules.add(new BaronesPierdenContraPobladoresRegla());
  }

  public static List<Rule>  getRules() {
    return rules;
  }
}
