//package com.richhaase.gameOfLife;
//
//import com.richhaase.gameOfLife.core.Board;
//
///**
// * Created by rdh on 9/26/14.
// */
//public class Game implements Runnable {
//
//  private Board board;
//  private int redraw;
//
//  public Game(int dimensions, int redraw) {
//    board = new Board(dimensions);
//    this.redraw = redraw;
//  }
//
//  public void run() {
//    do {
//      board.toAscii();
//      board.nextGeneration();
//      try {
//        Thread.sleep(redraw * 1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    } while (true);
//  }
//
//  public static void main(String[] args) {
//    Game game = new Game(10, 3);
//    game.run();
//  }
//}
