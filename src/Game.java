public class Game {
    public static final int MAX_MISSES = 8;
    private String answer;
    private String hits;
    private String misses;


    public Game(String answer){
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    private char normalizeGuess(char letter){
        if (! Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter)!= -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
            hits+=letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public String getCurrentProgress(){
        StringBuilder progress = new StringBuilder();
        for(char letter : answer.toCharArray()){
            char display = '-';
            if(hits.indexOf(letter) != -1){
                display = letter;
            }
            progress.append(display);
        }
        return progress.toString();
    }


}
