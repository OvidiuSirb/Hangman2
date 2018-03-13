import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            System.out.print("Enter a letter:  ");
            String guessInput = scanner.nextLine();

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } while (!isAcceptable);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left to solve.\nTry to solve: %s", game.getRemainingTries(), game.getCurrentProgress());
    }

    public void displayOutcome() {
        if(game.isWon()){
            System.out.printf("You won with %d tries remaining.",game.getRemainingTries());
        }else{
            System.out.printf("You lost. The answer was %s",game.getAnswer());
        }
    }
}
