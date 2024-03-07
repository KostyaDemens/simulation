package by.bsuir.kostyademens.action;

import by.bsuir.kostyademens.map.MapInterface;

public abstract class Action {
    MapInterface map;

    public Action(MapInterface map) {
        this.map = map;
    }

    public abstract void perform();
}
