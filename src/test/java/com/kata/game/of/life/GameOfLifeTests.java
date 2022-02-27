package com.kata.game.of.life;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by fabricejeannet on 16/09/2014.
 */
public class GameOfLifeTests {
    private GameOfLife gameOfLife;
    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }

    @Test
    public void founds_no_living_neighbours_in_an_empty_grid() {
        assertEquals(0,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_one_living_neighbour() {
        gameOfLife.setLivingCellColumn(0, 3,1);
        assertEquals(1,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_two_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,2);
        assertEquals(2,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_three_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        assertEquals(3,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_four_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellRow(1, 5,1);
        assertEquals(4,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_five_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellRow(1, 5,2);
        assertEquals(5,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_six_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellColumn(2, 4,1);
        gameOfLife.setLivingCellRow(1, 5,2);
        assertEquals(6,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_seven_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellColumn(2, 3,3);
        gameOfLife.setLivingCellColumn(1, 5,1);
        assertEquals(7,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_height_living_neighbours() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellColumn(2, 3,3);
        gameOfLife.setLivingCellColumn(1, 3,1);
        gameOfLife.setLivingCellColumn(1, 5,1);
        assertEquals(8,gameOfLife.countlivingNeighbours(1, 4));
    }

    @Test
    public void founds_three_living_neighbours_for_the_top_left_corner_cell() {
        gameOfLife.setLivingCellColumn(1, 0,2);
        gameOfLife.setLivingCellColumn(0, 1,1);
        assertEquals(3,gameOfLife.countlivingNeighbours(0, 0));
    }

    @Test
    public void founds_three_living_neighbours_for_the_bottom_left_corner_cell() {
        gameOfLife.setLivingCellColumn(2, 6,2);
        gameOfLife.setLivingCellColumn(3, 6,1);
        assertEquals(3,gameOfLife.countlivingNeighbours(3, 7));
    }

    @Test
    public void a_cell_with_fewer_than_two_neighbours_dies() {
        gameOfLife.setLivingCellColumn(1, 0,2);
        gameOfLife.computeNextGeneration();
        assertTrue(gameOfLife.isDead(0,0));
    }

    @Test
    public void a_cell_with_at_least_two_neighbours_lives() {
        gameOfLife.setLivingCellColumn(0, 0,2);
        gameOfLife.setLivingCellColumn(1, 1,1);
        gameOfLife.computeNextGeneration();
        assertTrue(gameOfLife.isAlive(0,0));
    }

    @Test
    public void a_cell_with_more_than_three_neighbours_dies() {
        gameOfLife.setLivingCellColumn(0, 3,3);
        gameOfLife.setLivingCellColumn(1, 4,2);
        gameOfLife.computeNextGeneration();
        assertTrue(gameOfLife.isDead(1,4));
    }

//    @Test
//    public void a_dead_cell_with_three_neighbours_gets_alive() {
//        gameOfLife.setLivingCellColumn(0, 3,3);
//        gameOfLife.computeNextGeneration();
//        assertEquals(true,gameOfLife.isAlive(1,4));
//    }
//
//    @Test
//    public void testAnHandMadeGrid() {
//        gameOfLife.setLivingCellColumn(1, 4,1);
//        gameOfLife.setLivingCellColumn(2, 3,2);
//        gameOfLife.computeNextGeneration();
//        int [][] expectedGrid = new int[][]{
//                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
//                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
//                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
//                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL}
//        };
//        assertEquals(true,Arrays.deepEquals(gameOfLife.grid, expectedGrid));
//    }

}
