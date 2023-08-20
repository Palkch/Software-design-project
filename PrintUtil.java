/**
 * Utility class for printing messages related to the game.
 */
public class PrintUtil {

    public void openingMessage() {
        System.out.println("It's a war of cards!\n" +
                "This Game is automated and will play until one deck is empty or the game reaches 25 rounds.\n" +
                "It's you against the CPU.\n");
        System.out.println("Please enter your name.");
        System.out.println("Indicate that you are ready by hitting enter.");
    }

    public void startGameMessage(Player player) {
        System.out.printf("%s, let's Play!\n", player.getName());
    }

    public void printRoundHeader(Player playerOne, Player playerTwo) {
        String header = "#CardsInHand";
        String winner = "Round Winner";
        System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", playerOne.getName(), header, playerTwo.getName(), header, winner);
    }

    // Print out winnings for each round and final winner of the game.
    public void announceRoundWinner(Player player1, Card card1, Player player2, Card card2, String winner) {
        System.out.printf("%-20s %-20s %-20s %-20s %s is the winner.\n", card1.toString(), player1.getHand().handSize(), card2.toString(), player2.getHand().handSize(), winner);
    }

    // Print war round message
    public void announceWarRound() {
        System.out.println("WAR! There was a tie and War was initiated.");
    }

    public void announceGameWinner(Player player) {
        System.out.printf("The winner of the game is %s!\n", player.getName());
    }

    public void announceDraw() {
        System.out.println("Sorry, the game ended in a draw.");
    }
}
