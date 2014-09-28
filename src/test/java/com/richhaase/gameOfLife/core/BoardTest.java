package com.richhaase.gameOfLife.core;

import com.richhaase.gameOfLife.utility.BoardUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

  Board randomizedBoard;
  Board definedBoard;

  @Before
  public void setup() throws Exception {
    randomizedBoard = new Board(4, 5);
    definedBoard = BoardUtils.fiveByfiveChevrons();
  }

  @Test
  public void testToAscii() throws Exception {
    String expected =
        "*---------------*\n" +
        "|       @       |\n" +
        "|    @     @    |\n" +
        "| @     @     @ |\n" +
        "|    @     @    |\n" +
        "| @           @ |\n" +
        "*---------------*\n";

    assertEquals(expected, definedBoard.toString());
  }

  @Test
  public void testValidBoardPositions() {
    assertTrue(randomizedBoard.isValidBoardPosition(new Coordinate(3, 2)));
    assertTrue(randomizedBoard.isValidBoardPosition(new Coordinate(0,0)));
    assertTrue(randomizedBoard.isValidBoardPosition(new Coordinate(3, 4)));
  }

  @Test
  public void testInvalidBoardPositions() {
    assertFalse(randomizedBoard.isValidBoardPosition(new Coordinate(-1, 0)));
    assertFalse(randomizedBoard.isValidBoardPosition(new Coordinate(0, -1)));
    assertFalse(randomizedBoard.isValidBoardPosition(new Coordinate(4, 5)));
  }


  @Test
  public void testCountLiveNeighbors() {
    assertEquals(2, definedBoard.countLiveNeighbors(new Coordinate(0, 2)));
    assertEquals(4, definedBoard.countLiveNeighbors(new Coordinate(2, 2)));
    assertEquals(3, definedBoard.countLiveNeighbors(new Coordinate(3, 0)));
  }

  @Test
  public void testNextGeneration() {
    assertNotEquals(new Board(5, 5), definedBoard.nextGeneration());
    assertEquals(BoardUtils.fiveByfiveChevronsSecondGen(), definedBoard.nextGeneration());
  }

}