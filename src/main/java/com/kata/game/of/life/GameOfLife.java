package com.kata.game.of.life;

import java.util.Arrays;

/**
 * Created by fabricejeannet on 16/09/2014.
 */
public class GameOfLife {

    private int rowCount;
    private int columnCount;
    public int[][] grid;
    public final static int DEAD_CELL = 0;
    public final static int LIVING_CELL = 1;

    public GameOfLife(int rowCount, int columnCount) {
        grid = new int [rowCount][columnCount];
        this.rowCount = grid.length;
        this.columnCount = grid[0].length;
    }

    public int countlivingNeighbours(int row, int column) {
        int[][] cellsToCheck = setCellsToCheck(row,column);
        int livingNeighbours = 0;

        for (int i = 0; i < cellsToCheck.length; i++) {
            int rowToCheck = cellsToCheck[i][0];
            int colTocheck = cellsToCheck[i][1];
            if (isInTheGrid(rowToCheck, colTocheck) && isAlive(rowToCheck, colTocheck)) {
                livingNeighbours ++ ;
            }
        }
        return livingNeighbours;
    }

    public int[][] setCellsToCheck(int row,int column){
        int[][] cellsToCheck = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row, column - 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
        };
        return cellsToCheck;
    }

    public void setLivingCellRow(int row, int column,int nth) {
        for(int i=0;i<nth;i++) {
            grid[row][column] = LIVING_CELL;
            row++;
        }
    }

    public void setLivingCellColumn(int row, int column,int nth) {
        for(int i=0;i<nth;i++) {
            grid[row][column] = LIVING_CELL;
            column++;
        }
    }

    private boolean isInTheGrid(int row, int col) {
        return row >= 0 && row < rowCount && col >= 0  && col < columnCount;
    }

    public boolean isAlive(int row, int column) {
        return grid[row][column] == LIVING_CELL;
    }

    public boolean isDead(int row, int column) {
        return grid[row][column] == DEAD_CELL;
    }

    public void computeNextGeneration() {
        int[][] nextGenerationGrid = new int[rowCount][columnCount];
        for (int y = 0; y < rowCount; y++) {
            for (int x = 0; x < columnCount; x++) {
                if (thisCellIsAliveAndHasNLivingNeighbors(y, x) <2 ||thisCellIsAliveAndHasNLivingNeighbors(y, x) >3 ) {
                    nextGenerationGrid[y][x] = DEAD_CELL;
                }else if (thisCellIsDeadAndHasThreeLivingNeighbors(y, x) || thisCellIsAliveAndHasNLivingNeighbors(y, x) ==3 || thisCellIsAliveAndHasNLivingNeighbors(y, x) ==2) {
                    nextGenerationGrid[y][x] = LIVING_CELL;
                }else{
                    nextGenerationGrid[y][x] = grid[y][x];
                }
            }
        }
        grid = nextGenerationGrid.clone();
    }

    private boolean thisCellIsDeadAndHasThreeLivingNeighbors(int row, int column) {
        return isDead(row, column) && countlivingNeighbours(row, column) == 3;
    }

    private int thisCellIsAliveAndHasNLivingNeighbors(int row, int column) {
        return isAlive(row, column) ? countlivingNeighbours(row, column) : 0 ;
    }
}
