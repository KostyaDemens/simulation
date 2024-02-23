package by.bsuir.kostyademens;

import by.bsuir.kostyademens.action.SpawnRockAction;
import by.bsuir.kostyademens.map.MapImpl;

public class Main {
    public static void main(String[] args) {
        MapImpl map = new MapImpl();
        Renderer renderer = new Renderer();

        SpawnRockAction spawnRock = new SpawnRockAction(map);
        spawnRock.perform();

        renderer.render(map);
    }
}