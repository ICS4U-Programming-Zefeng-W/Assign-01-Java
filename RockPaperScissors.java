/*
 * This program reads the user's input of either rock, paper, or scissors and 
   will compare it with the computer's choice, which is random. It will then
   display the result. 
 *
 *
 * By Zefeng Wang
 * Created on December 2, 2021
 * */

//import Scanner class.
import java.util.Scanner;

// class RockPaperScissors.
class RockPaperScissors {
  public static String[] moves = {"rock", "paper", "scissors"};
  
  // Reads input of user and compares it to computer's input, and outputs result
  public static void main(String[] args) {
    boolean start = true;
    int playerNum = 0;
    String playerMove = "";
    Scanner scannerObj = new Scanner(System.in);
    while (true) {
      int computerNum = (int) (Math.random() * 3);
      String computerMove = moves[computerNum];
      System.out.println("Please enter either 0(rock), 1(paper), or 2(scissors): ");
      try {
        playerNum = Integer.parseInt(scannerObj.next());
        playerMove = moves[playerNum];
      } catch (Exception e) {
        System.out.println("Please enter an integer of 0, 1, or 2.");
        continue;
      }
      if (compareMoves(playerNum, computerNum) == 1) {
        System.out.printf("Player picked %s and the computer picked %s, so Player wins!\n",
                          playerMove, computerMove);
      } else if (compareMoves(playerNum, computerNum) == 2) {
        System.out.printf("Player picked %s and the computer picked %s, so Computer wins!\n",
                          playerMove, computerMove);
      } else {
        System.out.printf("Player picked %s and the computer picked %s, so it was a tie!\n",
                          playerMove, computerMove);
      }
      break;
    }
  }

  public static int compareMoves(int playerMove, int computerMove) {
    int playerWin = -1;
    if (playerMove == computerMove) {
      playerWin = 0;
    } else if ((playerMove > computerMove && !(playerMove == 2 && computerMove == 0)) 
               || (computerMove == 2 && playerMove == 0)) {
      playerWin = 1;
    } else {
      playerWin = 2;
    }
    return playerWin;
  }
}
