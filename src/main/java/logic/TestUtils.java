package logic;

import java.util.List;

/**
 * @author Duvis Gómez && Martin Vivanco
 */
public class TestUtils {

    public static boolean testPk(List<Double> list, int acceptationGrades) {
        PokerTest pT = new PokerTest(acceptationGrades, list);
        pT.processPokerTest();
        return pT.getSummationProbabilities() < 12.591587? true: false;
    }

}
