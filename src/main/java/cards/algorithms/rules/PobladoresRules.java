package cards.algorithms.rules;

import cards.algorithms.rules.barones.BaronesGananContraDosGruposRegla;
import cards.algorithms.rules.barones.BaronesGananContraPobladoresRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraDosGruposRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraPobladoresRegla;
import cards.algorithms.rules.barones.BaronesPierdenContraTodosRegla;
import cards.algorithms.rules.lobos.LobosGananControPobladoresYBaronesRegla;
import cards.algorithms.rules.lobos.LobosPierdenControPobladoresYBaronesRegla;
import cards.algorithms.rules.pobladores.PobladoresGananContraBaronesRegla;
import cards.algorithms.rules.pobladores.PobladoresGananContraDosGruposRegla;
import cards.algorithms.rules.pobladores.PobladoresPierdenContraBaronesRegla;
import cards.algorithms.rules.pobladores.PobladoresPierdenContraDosGruposRegla;
import cards.algorithms.rules.pobladores.PobladoresPierdenContraTodosRegla;
import cards.helpers.rules.Rule;
import java.util.ArrayList;
import java.util.List;

public class PobladoresRules {
  private static List<Rule> rules = new ArrayList<>();

  static {
    rules.add(new PobladoresPierdenContraTodosRegla());
    rules.add(new PobladoresPierdenContraDosGruposRegla());
    rules.add(new PobladoresGananContraDosGruposRegla());
    rules.add(new PobladoresGananContraBaronesRegla());
    rules.add(new PobladoresPierdenContraBaronesRegla());
  }

  public static List<Rule>  getRules() {
    return rules;
  }
}
