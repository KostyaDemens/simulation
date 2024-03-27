package by.bsuir.kostyademens.action.move;

import by.bsuir.kostyademens.action.Action;
import by.bsuir.kostyademens.entity.creature.Creature;
import by.bsuir.kostyademens.map.GameMap;

import java.util.List;

public class MoveCreatureAction implements Action {

    private final GameMap map;

    public MoveCreatureAction(GameMap map) {
        this.map = map;
    }

    @Override
    public void perform() {
        List<Creature> creatures = map.getListOfEntitiesOnTheMap(Creature.class);
        for (Creature creature : creatures) {
            if (creature.getHealPoints() <= 0) {
                continue;
            }
            creature.makeMove(map);
        }
    }
}
