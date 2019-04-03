package org.LickingHeights;


import java.util.Random;

public class Deck {

    String[] Suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    String[] Rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


    private Card[] deck;


    private int cardsUsed;




    public Deck() {
        deck = new Card[52];
        buildDeck();
        shuffle();




    }

    private void buildDeck() {

        for (int i = 0; i < deck.length; i++) {
            deck[i] = new Card();
            deck[i].setSuit(Suits[i / 13]);
            deck[i].setName(Rank[i % 13]);

            if (i % 13 < 10) {
                deck[i].setValue((i % 13) + 1);


            }

            if (i % 13 >= 10) {
                deck[i].setValue(10);
            }


            cardsUsed = 0;
        }


    }

    public void reshuffle(){
        buildDeck();


        shuffle();
    }



    public void shuffle() {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsUsed = 0;
    }

    public int cardsLeft() {
        return deck.length - cardsUsed;
    }

    public Card dealCard(){
        if (cardsUsed == deck.length-1) {
            reshuffle();

        }
        cardsUsed++;
        Card card = deck[cardsUsed-1];
        deck[cardsUsed-1] = null;
        return card;
    }


    public void printDeck(){
        for(Card card: deck){
            System.out.println(card);
        }
    }
}

