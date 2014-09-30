package com.richhaase.gameOfLife.core;

import java.util.*;

/**
* Created by rdh on 9/26/14.
*/
public class Board implements Iterable<Cell> {

  private final int MIN_NEIGHBORS = 2;
  private final int MAX_NEIGHBORS = 3;
  private final int OPTIMAL_NEIGHBORS = 3;

  private final int height;
  private final int width;

  private Map<Coordinate, Cell> cellMapping = new HashMap<>();

  /**
   * Constructor
   *
   * Creates a board with the given dimensions.
   * The cells are given their state (alive or dead)
   * randomly.
   *
   * @param height height of the board
   * @param width  width of the board
   */
  public Board(int height, int width) {
    this.height = height;
    this.width = width;

    Random random = new Random();
    for (int x = 0; x < height; x++) {
      for (int y = 0; y < width; y++) {
        Coordinate coordinate = new Coordinate(x, y);
        Cell cell = new Cell(coordinate, false);
        if (random.nextBoolean()) { cell.spawn(); } else { cell.kill(); }
        cellMapping.put(coordinate, cell);
      }
    }

  }

  /**
   * Constructor
   *
   * Creates a board from a <code>Map<Coordinate, Cell>()</code>.
   * This options allows you to configure your initial board
   * in any way you choose.
   *
   * @param cells a list of cells <code>List<Cell>()</code>
   */
  public Board(int height, int width, List<Cell> cells) {
    this.height = height;
    this.width = width;

    for (Cell cell : cells) {
      cellMapping.put(cell.getCoordinate(), cell);
    }

    for (int x = 0; x < height; x++) {
      for (int y = 0; y < width; y++) {
        Coordinate coordinate = new Coordinate(x, y);
        if (! cellMapping.containsKey(coordinate)) {
          Cell cell = new Cell(coordinate, false);
          cell.kill();
          cellMapping.put(coordinate, cell);
        }
      }
    }
  }


  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  /**
   * Generates the next generation of the board
   *
   * @return a new <code>Board</code>
   */
  public Board nextGeneration() {
    List<Cell> cells = new ArrayList<>();

    for (Cell cell: cellMapping.values()) {
      int liveNeighbors = countLiveNeighbors(cell.getCoordinate());

      if (cell.isAlive()) {
        if (liveNeighbors < MIN_NEIGHBORS) {
          // under population cell dies
          cells.add(new Cell(cell.getCoordinate(), false));
        } else if (liveNeighbors > MAX_NEIGHBORS) {
          // over populated region of the board cell dies
          cells.add(new Cell(cell.getCoordinate(), false));
        } else {
          // optimal population level! cell survives
          cells.add(new Cell(cell.getCoordinate(), true));
        }
      } else {
        if (liveNeighbors == OPTIMAL_NEIGHBORS) {
          // optimal population level! spawn a new cell
          cells.add(new Cell(cell.getCoordinate(), true));
        } else {
          // cell is not spawned
          cells.add(new Cell(cell.getCoordinate(), false));
        }
      }
    }

    return new Board(height, width, cells);
  }

  /**
   * takes a coordinate and returns a count of the number
   * of adjacent cells on the board, which are <code>alive</code>.
   *
   * @param coordinate  the <code>Coordinate()</code> whose neighors are to be counted
   * @return            an <code>int</code> counting live neighboring cells
   */
  int countLiveNeighbors(Coordinate coordinate) {
    int count = 0;
    for (Coordinate c: coordinate.getAdjacencies()) {
      if (isValidBoardPosition(c) && cellMapping.get(c).isAlive()) {
        count++;
      }
    }
    return count;
  }

  /**
   * A predicate method used to determine whether a coordinate
   * is valid for this instance of the <code>Board</code>
   *
   * @param coordinate  the <code>Coordinate</code> to be killed
   * @return true or false
   */
  boolean isValidBoardPosition(Coordinate coordinate) {
    int x = coordinate.getX();
    int y = coordinate.getY();
    return x >= 0 && x < height && y >= 0 && y < width;
  }

  /**
   * Helper method
   *
   * Kills the cell at a given coordinate on the board
   *
   * @param coordinate the <code>Coordinate()</code> to be killed
   */
  public void killCell(Coordinate coordinate) {
    cellMapping.get(coordinate).kill();
  }

  /**
   * Helper method
   *
   * Spawns the cell at a given coordinate on board
   *
   * @param coordinate the <code>Coordinate()</code> to be spawned
   */
  public void spawnCell(Coordinate coordinate) {
    cellMapping.get(coordinate).spawn();
  }

  /**
   *
   */
  public Iterator<Map.Entry<Coordinate, Cell>> get() {
    return cellMapping.entrySet().iterator();
  }

  /**
   * generates an appropriately sized heading <code>String</code>,
   * like:
   *
   *   <code>"*------*"</code>
   *
   * @return <code>String</code>
   */
  private String asciiHeader() {
    String corner = "*";
    StringBuilder sb = new StringBuilder();

    sb.append(corner);
    for (int n = 0; n < width; n++) {
      sb.append("---");
    }
    sb.append(corner).append("\n");

    return sb.toString();
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    if (! (that instanceof Board)) return false;
    Board thatBoard = (Board) that;
    return thatBoard.height == height &&
        thatBoard.width == width &&
        thatBoard.cellMapping.equals(cellMapping);
  }

  @Override
  public Iterator<Cell> iterator() {
    return cellMapping.values().iterator();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(asciiHeader());

    for (int n = 0; n < height; n++) {
      sb.append("|");
      for (int m = 0; m < width; m++) {
        Coordinate coordinate = new Coordinate(n, m);
        Cell cell = cellMapping.get(coordinate);
        sb.append(cell);
      }
      sb.append("|\n");
    }
    sb.append(asciiHeader());

    return sb.toString();
  }

}
