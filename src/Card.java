public class Card {

    public int cardNumber;
    public int suitNumber;
    public String suitName;
    public String cardName;
    public int pointValue;






    public Card() { // default constructor
    }

    // another constructor that takes number of toppings as a parameter
    public Card(int psuitNumber, int pcardNumber) {

        this.cardNumber = pcardNumber;
        this.suitNumber = psuitNumber;

        if (cardNumber == 1){
            cardName = "ace";
            pointValue = 1;
        }
        else if (cardNumber == 2){
            cardName = "2";
            pointValue = 2;
        }
        else if (cardNumber == 3){
            cardName = "3";
            pointValue = 3;
        }
        else if (cardNumber == 4){
            cardName = "4";
            pointValue = 4;
        }
        else if (cardNumber == 4){
            cardName = "4";
            pointValue = 4;
        }
        else if (cardNumber == 5){
            cardName = "5";
            pointValue = 5;
        }
        else if (cardNumber == 6){
            cardName = "6";
            pointValue = 6;
        }
        else if (cardNumber == 7){
            cardName = "7";
            pointValue = 7;
        }
        else if (cardNumber == 8){
            cardName = "8";
            pointValue = 8;
        }
        else if (cardNumber == 9){
            cardName = "9";
            pointValue = 9;
        }
        else if (cardNumber == 10){
            cardName = "10";
            pointValue = 10;
        }
        else if (cardNumber == 11){
            cardName = "jack";
            pointValue = 10;
        }
        else if (cardNumber == 12){
            cardName = "queen";
            pointValue = 10;
        }
        else if (cardNumber == 13){
            cardName = "king";
            pointValue = 10;
        }

        if (suitNumber == 1){
            suitName = "spades";
        }
        else if (suitNumber == 2){
            suitName = "clubs";
        }
        else if (suitNumber == 3){
            suitName = "diamonds";
        }
        else if (suitNumber == 4){
            suitName = "hearts";
        }

    }


    // method to print info about the taco
    public void printInfo() {
        System.out.println(cardName+" of "+suitName);
    }
}