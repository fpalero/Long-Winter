package cards;

import cards.algorithms.Algorithm1;
import cards.generator.Card;
import cards.generator.Deck;
import cards.generator.RandomCards;
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class Main {

  //// Variables de configuración algoritmo
  // Cuantas veces ejecutar el algoritmo
  public static final int ITEATIONS = 100;
  // Cuantas rondas tiene un partida, se ha puesto 48 porque es el numero de cartas de una
  // baraja, sin contar los comodines.
  public static final int ROUNDS = 48;


  // Valores estaticos
  public static final int POBLADORES = 0;
  public static final int BARONES = 1;
  public static final int LOBOS = 2;
  public static final int ARQUITECTOS = 3;


  public static void main(String[] args) {
    Deck deck = new Deck();
    Algorithm1 algorithm1 = new Algorithm1();
    RandomCards randomCards = new RandomCards(deck);

    double [] rondas = new double[ITEATIONS];
    // pobladores
    double [][] poblExitos = new double[2][ITEATIONS];
    double [] pexitos = new double[ITEATIONS];
    double [] pfallos = new double[ITEATIONS];
    //Barones
    double [][] barExitos = new double[2][ITEATIONS];
    double [] bexitos = new double[ITEATIONS];
    double [] bfallos = new double[ITEATIONS];

    // Comparativas
    double [][] failsExitos = new double[4][ITEATIONS];
    double [][] successExitos = new double[4][ITEATIONS];
    for (int i = 0; i < ITEATIONS; i++) {
      rondas[i] = i;
      randomCards.order();
      randomCards.shuffle();

      Card card;
      algorithm1.init();
      int iter = 0;
      while (iter < ROUNDS) {
        card = randomCards.getCard();
        algorithm1.calculateStatus(card);
        iter++;
      }

      // Pobladores
      pexitos[i] = algorithm1.pobladores.success;
      pfallos[i] = algorithm1.pobladores.fails;
      poblExitos[0][i] = algorithm1.pobladores.success;
      poblExitos[1][i] = algorithm1.pobladores.fails;
      //barones
      bexitos[i] = algorithm1.barones.success;
      bfallos[i] = algorithm1.barones.fails;
      barExitos[0][i] = algorithm1.barones.success;
      barExitos[1][i] = algorithm1.barones.fails;

      // Comparativas
      failsExitos[POBLADORES][i] = algorithm1.pobladores.fails;
      failsExitos[BARONES][i] = algorithm1.barones.fails;
      failsExitos[LOBOS][i] = algorithm1.lobos.fails;
      failsExitos[ARQUITECTOS][i] = algorithm1.barones.fails;

      successExitos[POBLADORES][i] = algorithm1.pobladores.success;
      successExitos[BARONES][i] = algorithm1.barones.success;
      successExitos[LOBOS][i] = algorithm1.lobos.success;
      successExitos[ARQUITECTOS][i] = algorithm1.arquitectos.success;
    }

    List<XYChart> charts = new ArrayList<XYChart>();

    String [] names = {"exito", "fallo"};
    String [] names2 = {"pobladores", "barones", "lobos", "arquitectos"};
    // Create Chart
    XYChart pchart = QuickChart.getChart("Pobladores", "Rondas", "Puntos", names, rondas,
        poblExitos);

    XYChart bchart = QuickChart.getChart("Barones ", "Rondas", "Puntos", names, rondas,
        barExitos);

    XYChart success = QuickChart.getChart("sucess ", "Rondas", "Puntos", names2, rondas,
        successExitos);

    XYChart fails = QuickChart.getChart("fails ", "Rondas", "Puntos", names2, rondas,
        failsExitos);

    charts.add(pchart);
    charts.add(bchart);
    charts.add(success);
    charts.add(fails);

    // Show it
    new SwingWrapper(charts).displayChartMatrix();
  }
}
