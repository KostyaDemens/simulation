package by.bsuir.kostyademens.animate;

import by.bsuir.kostyademens.Coordinates;
import by.bsuir.kostyademens.map.MapImpl;

import java.util.List;

public class Wolf extends Creature {
    private int damagePoints;

    public Wolf(Coordinates coordinates, int damagePoints, int healPoints, int speed) {
        super(coordinates, healPoints, speed);
        this.damagePoints = damagePoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public void makeMove(MapImpl map) {

        // TODO: попробовать переписать на while, чтобы вместо i и j была одна общая переменная, соответствующая оставшемуся числу ходов на ходе
        // TODO: предусмотреть случаи, когда path.size() < speed (в таком случае ищем новый путь и идем по нему или бродим, если не нашли)
        // Также реализовать эти пункты в кролике
        for (int i = 0; i < speed; i++) {

            List<Coordinates> path = pathBuilder.buildPath(map, getCoordinates(), Rabbit.class);
            if (path == null) {
                roamAround(map);
            } else {
                int j;
                for (j = i; j < speed; j++) {
                    Coordinates coordinates = path.get(j);
                    if (j == path.size() - 2) {
                        break;
                    }
                    map.makeMove(this.getCoordinates(), coordinates, this);
                }
                for (; j < speed; j++) {
                    eat();
                    // TODO: добавить механику дамага
                }
            }
        }
    }

    @Override
    public void eat() {
        healPoints++;
    }

}
