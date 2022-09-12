import java.util.ArrayList;

public class Player {
//    public boolean hit;
//    public boolean stand;
    public int score;
    ArrayList<Card> hand = new ArrayList<>();

    public Player() {
        score = 0;
    }

    public void printhand() {
        for (int h = 0; h < hand.size(); h++) {
            hand.get(h).printInfo();
        }
    }

    public void checkScore() {
        for (int p = 0; p < hand.size(); p++) {
            score = score + hand.get(p).pointValue;
        }
    }

    public boolean checkBlackjack() {
        if (score == 21) {
            return true;

        } else {
            return false;
        }
    }

    public boolean checkbust() {
        if (score>21) {
            return true;

        }else{
            return false;
        }
    }



}