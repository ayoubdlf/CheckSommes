package checkSommes.fabrique;

import checkSommes.modele.Case;


public class FabriquePlateau {

    public static Case[][] FabriquePlateau5x5() {
        Case[][] cases = {
                { new Case(1), new Case(2), new Case(1), new Case(2), new Case(2) },
                { new Case(3), new Case(3), new Case(2), new Case(1), new Case(6) },
                { new Case(2), new Case(7), new Case(2), new Case(7), new Case(2) },
                { new Case(3), new Case(1), new Case(5), new Case(1), new Case(6) }
        };

        cases[0][1].setEstSolution();
        cases[0][3].setEstSolution();
        cases[0][4].setEstSolution();

        cases[1][1].setEstSolution();
        cases[1][2].setEstSolution();

        cases[2][0].setEstSolution();
        cases[2][3].setEstSolution();

        cases[3][1].setEstSolution();
        cases[3][4].setEstSolution();


        return cases;
    }

}



// 1 *2 1 *2 *2
// 3 *3 *2 1 6
// *2 7 2 *7 2
// 3 *1 5 1 *6
