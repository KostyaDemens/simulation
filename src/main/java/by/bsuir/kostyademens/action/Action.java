package by.bsuir.kostyademens.action;

import by.bsuir.kostyademens.map.MapImpl;

public abstract class Action {
    MapImpl map;

    public Action(MapImpl map) {
        this.map = map;
    }

    public abstract void perform();
}
