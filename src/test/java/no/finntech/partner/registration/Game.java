package no.finntech.partner.registration;

import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Joiner;

public class Game {

    boolean[][] world = new boolean[3][3];

    public Game(String world) {
        String[] split = world.split("\n");
        for (int i = 0; i < split.length; i++) {
            String line = split[i];
            for (int j = 0; j < line.length(); j++) {
                this.world[i][j] = line.charAt(j) == 'X';
            }

        }
    }

    public String generation() {
        boolean[][] nextGeneration = new boolean[3][3];
        System.arraycopy(world, 0, nextGeneration, 0, 3);
        for (int i = 0; i < world.length; i++) {
            boolean[] row = world[i];
            for (int j = 0; j < row.length; j++) {
                boolean cell = row[j];
                if (numNeighbours(i,j) < 2) {
                    nextGeneration[i][j] = false;
                }

            }
        }

        world =nextGeneration;
        return print();
    }

    private int numNeighbours(int i, int j) {
        int numNeigbours = 0;
        numNeigbours += alive(i - 1, j - 1) ? 1 : 0;
        numNeigbours += alive(i-1, j) ? 1 : 0;
        numNeigbours += alive(i-1, j+1) ? 1 : 0;
        numNeigbours += alive(i, j-1) ? 1 : 0;
        numNeigbours += alive(i, j+1) ? 1 : 0;
        numNeigbours += alive(i+1, j-1) ? 1 : 0;
        numNeigbours += alive(i+1, j) ? 1 : 0;
        numNeigbours += alive(i+1, j+1) ? 1 : 0;
        return numNeigbours;
    }

    private boolean alive(int i, int j) {
        if (i < 0) return false;
        if (j < 0) return false;
        if (i >= world.length) return false;
        if (j >= world[0].length) return false;
        return world[i][j];
    }

    private String print() {
        List<String> worldState = new LinkedList<>();
        for (int i = 0; i < world.length; i++) {
            StringBuilder worldLine = new StringBuilder();
            for (int j =0; j < world.length; j++) {
                worldLine.append(world[i][j] ? 'X' : '.');
            }
            worldState.add(worldLine.toString());
        }
        return Joiner.on("\n").join(worldState);
    }
}
