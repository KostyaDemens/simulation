package by.bsuir.kostyademens;


import by.bsuir.kostyademens.map.GameMap;

public class Main {
    public static void main(String[] args) {
        MapFactory mapFactory = new MapFactory();

        GameMap map = mapFactory.get();

        Game game = new Game(map);
        game.start();

    }


}