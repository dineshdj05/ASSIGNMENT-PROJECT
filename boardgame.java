import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class SnakeNLadder {
    final static int WINPOINT = 100;
    static Map<Integer, Integer> snake = new HashMap<>();
    static Map<Integer, Integer> ladder = new HashMap<>();
    int player1 = 0, player2 = 0;
    int currentPlayer = -1;
    Random rand = new Random();

    public SnakeNLadder() {
        snake.put(99,78); snake.put(95,75); snake.put(92,88); snake.put(74,53);
        snake.put(64,60); snake.put(62,19); snake.put(49,11); snake.put(46,25); snake.put(16,6);
        ladder.put(2,38); ladder.put(7,14); ladder.put(8,31); ladder.put(15,26);
        ladder.put(21,42); ladder.put(28,84); ladder.put(36,44); ladder.put(51,67);
        ladder.put(71,91); ladder.put(78,98); ladder.put(87,94);
    }

    public int rollDice() {
        return rand.nextInt(6) + 1;
    }

    public int calculatePlayerValue(int player, int diceValue) {
        player = player + diceValue;
        if(player > WINPOINT) {
            player = player - diceValue;
        }
        if(snake.containsKey(player)) {
            System.out.println("Oops! Swallowed by a snake.");
            player = snake.get(player);
        }
        if(ladder.containsKey(player)) {
            System.out.println("Yay! Up the ladder.");
            player = ladder.get(player);
        }
        return player;
    }

    public boolean isWin(int player) {
        return player == WINPOINT;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.println((currentPlayer == -1) ? "First Player turn" : "Second Player turn");
            System.out.println("Press r to roll Dice");
            str = sc.next();
            int diceValue = rollDice();
            System.out.println("Dice Value: " + diceValue);

            if(currentPlayer == -1) {
                player1 = calculatePlayerValue(player1, diceValue);
                System.out.println("First Player Position: " + player1);
                System.out.println("Second Player Position: " + player2);
                if(isWin(player1)) {
                    System.out.println("First player wins!");
                    break;
                }
            } else {
                player2 = calculatePlayerValue(player2, diceValue);
                System.out.println("First Player Position: " + player1);
                System.out.println("Second Player Position: " + player2);
                if(isWin(player2)) {
                    System.out.println("Second player wins!");
                    break;
                }
            }
            currentPlayer = -currentPlayer;
        } while("r".equals(str));
    }
}

public class SnakeNLadderTest {
    public static void main(String[] args) {
        SnakeNLadder game = new SnakeNLadder();
        game.startGame();
    }
}
