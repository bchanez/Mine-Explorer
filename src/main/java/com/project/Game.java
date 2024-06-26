package com.project;

public class Game {

  private Menu menu;
  private Board board;
  private Player player;

  private boolean gameRunning;

  public Game(Menu menu, Player player) throws Exception {
    this.menu = menu;
    this.player = player;

    board = new Board(menu.getNbRow(), menu.getNbColumn(), player);

    gameRunning = true;
  }

  public void loop() {
    do {
      System.out.println(board);
      handleAction(menu.doAction(player));
    } while (gameRunning);
  }

  private void handleAction(int action) {
    switch (action) {
      case 0:
        gameRunning = false;
        break;
      case 1:
        player.moveToDirection(menu.chooseDirection());
        break;
      case 2:
        player.throwGrenadeInDirection(menu.chooseDirection());
        break;
      default:
        break;
    }
  }

  public boolean isGameRunning() {
    return gameRunning;
  }
}
