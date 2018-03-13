public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Game game = new Game("Pirocoparcanita");
        Prompter prompter = new Prompter(game);
        while (game.getRemainingTries() > 0){
            prompter.displayProgress();
            prompter.promptForGuess();
        }


    }
}
