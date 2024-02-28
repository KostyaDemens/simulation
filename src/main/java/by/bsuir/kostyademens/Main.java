package by.bsuir.kostyademens;


import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.inanimate.Rock;
import by.bsuir.kostyademens.inanimate.Tree;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.pathfinder.PathBuilder;


public class Main {
    public static void main(String[] args) {
        PathBuilder pathBuilder = new PathBuilder();
        MapImpl map = new MapImpl();
        Rock rock = new Rock(new Coordinates(4, 5));
        Rabbit rabbit = new Rabbit(new Coordinates(1, 1));
        Carrot carrot = new Carrot(new Coordinates(5, 5));
        Carrot carrot2 = new Carrot(new Coordinates(3, 3));
        Tree tree = new Tree(new Coordinates(5, 4));
        map.addEntity(new Coordinates(4, 5), rock);
        map.addEntity(new Coordinates(1, 1), rabbit);
        map.addEntity(new Coordinates(5, 5), carrot);
        map.addEntity(new Coordinates(3, 3), carrot2);
        map.addEntity(new Coordinates(5, 4), tree);

        System.out.println(pathBuilder.buildPath(map, rabbit.getCoordinates(), carrot));
    }
}