package com.richhaase.gameOfLife.utility;

import com.richhaase.gameOfLife.core.Board;
import com.richhaase.gameOfLife.core.Cell;
import com.richhaase.gameOfLife.core.Coordinate;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a number fo board definitions
 *
 * Created by rdh on 9/27/14.
 */
public class BoardUtils {

  public static Board fiveByfiveChevrons() {
    List<Cell> cells = new ArrayList<Cell>();

    // top/1st row
    cells.add(new Cell(0, 2, true));

    // 2nd row
    cells.add(new Cell(1, 1, true));
    cells.add(new Cell(1, 3, true));

    // 3rd row
    cells.add(new Cell(2, 0, true));
    cells.add(new Cell(2, 2, true));
    cells.add(new Cell(2, 4, true));

    // 4th row
    cells.add(new Cell(3, 1, true));
    cells.add(new Cell(3, 3, true));

    // bottom/5th row
    cells.add(new Cell(4, 0, true));
    cells.add(new Cell(4, 4, true));

    return new Board(5, 5 , cells);
  }

  public static Board fiveByfiveChevronsSecondGen() {
    Board board = fiveByfiveChevrons();

    board.killCell(new Coordinate(4, 0));
    board.killCell(new Coordinate(4, 4));
    board.killCell(new Coordinate(2, 2));
    board.spawnCell(new Coordinate(3, 0));
    board.spawnCell(new Coordinate(3, 2));
    board.spawnCell(new Coordinate(3, 4));

    return board;
  }
}
