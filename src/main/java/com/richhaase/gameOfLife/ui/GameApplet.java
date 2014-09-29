package com.richhaase.gameOfLife.ui;

import com.richhaase.gameOfLife.core.Board;
import com.richhaase.gameOfLife.core.Cell;

import java.awt.*;
import java.applet.*;
/*
<applet code="GameApplet" width=1024 height=768>
</applet>
 */


/**
 * Created by rdh on 9/28/14.
 */
public class GameApplet extends Applet implements Runnable {

  private boolean stop;
  private int redraw;
  private Board board;
  private Thread thread;

  public GameApplet(int height, int width, int redraw) {
    this.board = new Board(height, width);
    this.redraw = redraw;
  }

  public void run() {
    repaint();
    while (stop) {
      repaint();
      board = board.nextGeneration();
      try {
        Thread.sleep(redraw * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void init() {
    setBackground(Color.LIGHT_GRAY);
    setForeground(Color.BLACK);
  }

  public void start() {
    thread = new Thread(this);
    stop = false;
    thread.start();
  }

  public void stop() {
    stop = true;
  }

  public void destroy() {

  }

  public void paint(Graphics graphics) {
    for (Cell cell: board) {
      graphics.drawRect(
          cell.getCoordinate().getX(),
          cell.getCoordinate().getY(),
          1,
          1);
    }
  }
}
