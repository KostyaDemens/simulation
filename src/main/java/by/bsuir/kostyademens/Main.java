package by.bsuir.kostyademens;


import by.bsuir.kostyademens.action.spawnActions.SpawnRabbitAction;
import by.bsuir.kostyademens.animate.Rabbit;
import by.bsuir.kostyademens.inanimate.Carrot;
import by.bsuir.kostyademens.map.MapImpl;
import by.bsuir.kostyademens.pathfinder.PathBuilder;


public class Main {
    public static void main(String[] args) {
        PathBuilder pathBuilder = new PathBuilder();

        MapImpl map = new MapImpl();

        SpawnRabbitAction spawnRabbitAction = new SpawnRabbitAction(map);
        spawnRabbitAction.perform();

        Renderer renderer = new Renderer();

        Carrot carrot = new Carrot(new Coordinates(7, 7));
        map.addEntity(new Coordinates(7, 7), carrot);

        renderer.render(map);

        System.out.println(pathBuilder.buildPath(map, map.findEntity(Rabbit.class).getCoordinates(), Carrot.class));
    }
}