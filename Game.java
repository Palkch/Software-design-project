import java.util.List;
import java.util.Scanner;

public class Game {

    private Deck deck;
    private static PrintUtil printUtil = new PrintUtil();
    private Player humanPlayer;
    private Player cpuPlayer;
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        printUtil.openingMessage();

        String playerName = scanner.nextLine();
        humanPlayer = new Player(playerName);
        cpuPlayer = new Player("CPU");

        printUtil.startGameMessage(humanPlayer);

        deck = new Deck();
        deck.shuffleDeck();

        humanPlayer.setHand(new Hand());
        cpuPlayer.setHand(new Hand());

        dealCards(humanPlayer.getHand());
        dealCards(cpuPlayer.getHand());

        printUtil.printRoundHeader(humanPlayer, cpuPlayer);

        int maxRounds = 27;
        Player winner = null;
        while (maxRounds > 0) {
            scanner.nextLine(); // Wait for player to press Enter
            maxRounds--;

            boolean result = battle(humanPlayer, cpuPlayer, null);
            if (!result) {
                break;
            }

            if (humanPlayer.getHand().handSize() == 0) {
                winner = cpuPlayer;
                break;
            } else if (cpuPlayer.getHand().handSize() == 0) {
                winner = humanPlayer;
                break;
            }
        }

        if (winner != null) {
            printUtil.announceGameWinner(winner);
        } else {
            printUtil.announceDraw();
        }
    }

    public void dealCards(Hand hand) {
        for (int i = 0; i < 26; i++) {
            hand.addCardToTop(deck.dealCard());
        }
    }

    public boolean battle(Player playerOne, Player playerTwo, Hand pot) {
        Card playerOneFaceUp = playerOne.getHand().removeCardFromTop();
        if (playerOneFaceUp == null) {
            return false;
        }

        Card playerTwoFaceUp = playerTwo.getHand().removeCardFromTop();
        if (playerTwoFaceUp == null) {
            return false;
        }

        if (pot == null) {
            pot = new Hand();
        }
        pot.addCardToTop(playerOneFaceUp);
        pot.addCardToTop(playerTwoFaceUp);

        int result = playerOneFaceUp.compareTo(playerTwoFaceUp);
        switch (result) {
            case 0:
                printUtil.announceWarRound();

                List<Card> warPlayerOnePot = playerOne.getHand().take(3);
                if (warPlayerOnePot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerOnePot);

                List<Card> warPlayerTwoPot = playerTwo.getHand().take(3);
                if (warPlayerTwoPot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerTwoPot);

                return battle(playerOne, playerTwo, pot);
            case 1:
                playerOne.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerOne.getName());
                break;
            case -1:
                playerTwo.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerTwo.getName());
                break;
        }

        return true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}

