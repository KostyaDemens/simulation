package by.bsuir.kostyademens;


import by.bsuir.kostyademens.map.MapInterface;


public class Main {
    public static void main(String[] args) {


        MapFactory mapFactory = new MapFactory();

        MapInterface map = mapFactory.get();

        Game game = new Game(map);
        game.start();

    }



}