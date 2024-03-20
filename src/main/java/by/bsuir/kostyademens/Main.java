package by.bsuir.kostyademens;


import by.bsuir.kostyademens.map.MapImpl;

public class Main {
    public static void main(String[] args) {
        MapFactory mapFactory = new MapFactory();

        MapImpl map = mapFactory.get();

        Game game = new Game(map);
        game.start();

    }


}