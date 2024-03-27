package by.bsuir.kostyademens;


import by.bsuir.kostyademens.map.GameMap;

public class Main {
    public static void main(String[] args) {


        Simulation simulation = new Simulation(createMap());

        simulation.startSimulation();


    }

    public static GameMap createMap() {
        return new GameMap(7, 7);
    }


}