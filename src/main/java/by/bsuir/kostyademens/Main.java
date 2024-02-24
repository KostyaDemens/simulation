package by.bsuir.kostyademens;


import by.bsuir.kostyademens.pathfinder.PathBuilder;


public class Main {
    public static void main(String[] args) {
        PathBuilder pathBuilder = new PathBuilder();
        System.out.println(pathBuilder.getListOfNeighbours(new Coordinates(2, 2)));
    }
}