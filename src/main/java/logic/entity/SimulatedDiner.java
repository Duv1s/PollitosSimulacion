package logic.entity;

import java.util.List;

/**
 *  Simulacion correspondiente a X horas de trabajo, con X cantidad de comensales
 * @@author Duvis Gómez && Martin Vivanco
 */
public class SimulatedDiner {
        DishStat pl1 = new DishStat(Dish.BANDEJA_PAISA);
        DishStat pl2 = new DishStat(Dish.CUCHUCO_DE_TRIGO);
        DishStat pl3 = new DishStat(Dish.PAELLA_VALENCIANA);
        DishStat pl4 = new DishStat(Dish.ARROZ_CON_POLLO);

    public SimulatedDiner(List<Diner> diners) {
        for (int i = 0; i < diners.size(); i++) {
            Diner diner = diners.get(i);
            switch(diner.getDish()){
                case BANDEJA_PAISA:addDinnerToStat(diner, pl1);break;
                case CUCHUCO_DE_TRIGO:addDinnerToStat(diner, pl2);break;
                case PAELLA_VALENCIANA:addDinnerToStat(diner, pl3);break;
                case ARROZ_CON_POLLO:addDinnerToStat(diner, pl4);break;
                default:break;
            }
        }
    }

    private void addDinnerToStat(Diner d,DishStat ds){
        ds.addSell();
        if (d.isIsRated()) {
            ds.addRatedSell();
            ds.addRank(d.getRate());
        }
    }
/**
 * gets y sets
 */
    public DishStat getPl1() {
        return pl1;
    }

    public DishStat getPl2() {
        return pl2;
    }

    public DishStat getPl3() {
        return pl3;
    }

    public DishStat getPl4() {
        return pl4;
    }

}
