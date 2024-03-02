package by.bsuir.kostyademens;


import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.map.MapImpl;


public class Main {
    public static void main(String[] args) {

        MapImpl map = new MapImpl();

        Renderer renderer = new Renderer();

        Rabbit rabbit = new Rabbit(new Coordinates(1, 1));
        map.addEntity(new Coordinates(1, 1), rabbit);

        Carrot carrot = new Carrot(new Coordinates(7, 7));
        map.addEntity(new Coordinates(7, 7), carrot);

        Rock rock = new Rock(new Coordinates(6, 7));
        map.addEntity(new Coordinates(6, 7), rock);

        Rock rock1 = new Rock(new Coordinates(7, 8));
        map.addEntity(new Coordinates(7, 8), rock);

        Rock rock2 = new Rock(new Coordinates(7, 6));
        map.addEntity(new Coordinates(7, 6), rock);

        renderer.render(map);
        System.out.println();

        rabbit.makeMove(map);

        renderer.render(map);
    }
}