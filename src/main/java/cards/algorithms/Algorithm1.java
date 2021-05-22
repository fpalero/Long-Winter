package cards.algorithms;

import cards.algorithms.rules.ArquitectosRules;
import cards.algorithms.rules.BaronesRules;
import cards.algorithms.rules.LobosRules;
import cards.algorithms.rules.PobladoresRules;
import cards.generator.Card;
import cards.generator.CardType;
import cards.helpers.parties.Party;
import cards.helpers.rules.RuleChecker;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Algorithm1 {
  public Party barones;
  public Party pobladores;
  public Party lobos;
  public Party arquitectos;
  private Map<String, Party> parties;
  private Map<String, RuleChecker> ruleCheckerMap;

  public Algorithm1() {
    this.parties = new HashMap<>(4);
    this.ruleCheckerMap = new HashMap<>(4);
    init();
  }

  public void init() {
    this.parties.clear();
    this.ruleCheckerMap.clear();
    Random r = new Random(System.currentTimeMillis());

    inittBarones(r);

    initPobladores(r);

    initLobos(r);

    initArquitectos(r);
  }

  private void initArquitectos(Random r) {
    ///// Crear el grupo de los ARQUITECTOS
    // Crear las reglas de los ARQUITECTOS
    RuleChecker arquitectoRuleChecker = new RuleChecker(ArquitectosRules.getRules());
    //  Crear el grupo de los ARQUITECTOS, se le anyaden las reglas y un estado inicial
    this.arquitectos =
        new Party(new Card(CardType.ARQUITECTOS, r.nextInt(12)));
    this.parties.put(CardType.ARQUITECTOS, this.arquitectos);
    this.ruleCheckerMap.put(CardType.ARQUITECTOS, arquitectoRuleChecker);
  }

  private void initLobos(Random r) {
    ///// Crear el grupo de los LOBOS
    // Crear las reglas de los LOBOS
    RuleChecker lobosRuleChecker = new RuleChecker(LobosRules.getRules());
    //  Crear el grupo de los LOBOS, se le anyaden las reglas y un estado inicial
    this.lobos = new Party(new Card(CardType.LOBOS, r.nextInt(12)));
    this.parties.put(CardType.LOBOS, this.lobos);
    this.ruleCheckerMap.put(CardType.LOBOS, lobosRuleChecker);
  }

  private void initPobladores(Random r) {
    ///// Crear el grupo de los POBLADORES
    // Crear las reglas de los POBLADORES
    RuleChecker pobladoresRuleChecker = new RuleChecker(PobladoresRules.getRules());
    //  Crear el grupo de los POBLADORES, se le anyaden las reglas y un estado inicial
    this.pobladores =
        new Party(new Card(CardType.POBLADORES, r.nextInt(12)));
    //// Crear el mapa para guardar los grupos
    this.parties.put(CardType.POBLADORES, this.pobladores);
    //// Crear mapa para guardo los validadores de reglas
    this.ruleCheckerMap.put(CardType.POBLADORES, pobladoresRuleChecker);
  }

  private void inittBarones(Random r) {
    ///// Crear el grupo de los Barones
    // Crear las reglas de los barones
    RuleChecker baronesRuleChecker = new RuleChecker(BaronesRules.getRules());
    //  Crear el grupo de los barones, se le anyaden las reglas y un estado inicial
    this.barones = new Party(new Card(CardType.BARONES, r.nextInt(12)));
    this.parties.put(CardType.BARONES, this.barones);
    this.ruleCheckerMap.put(CardType.BARONES, baronesRuleChecker);
  }

  public void calculateStatus(Card card) {
    // la funcion calculate simula los enfrentamientos entre las diferentes facciones
    // para saber que facción ha ganado se mire el numero de la carta, el numero más pequeño
    // pierde. Una vez se sabe el resultado se actualiza el estado del grupo.
    this.ruleCheckerMap.get(card.type).check(parties, card);
  }

  @Override public String toString() {
    return String.format(
        "Pobladores S: %d F: %d Barones S: %d F: %d Lobos S: %d F: %d Arquitectos S: %d F: %d ",
        pobladores.success, pobladores.fails,
        barones.success, barones.fails,
        lobos.success, lobos.fails,
        arquitectos.success, arquitectos.fails
    );
  }
}
