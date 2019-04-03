package org.LickingHeights;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    private Deck deck;
    private ArrayList<Player>players;

    public BlackJack() {
        super();
        deck = new Deck();
        players = new ArrayList<>();
        init(4);

        //todo open a loop for the game

        //todo turn loop
        //todo switch who the current player is

        //todo give the current player option what they want to do for their turn

        //true would have to switch so that game can end.
        do {
            //method for dealing cards to every player


            for (Player player : players) {
                boolean turnOver = false;
                player.hitMe(deck.dealCard());
                player.hitMe(deck.dealCard());
                do {
                    System.out.println("\n\n"+player.getName() + "\n\nmoney: " + player.getMoney() + " bet: " + player.getBet());

                    player.getHand().printHand();
                    System.out.println("Your current hand total is "+ player.getHandTotal());
                   turnOver =  betChoice(player);

                   if(player.getHandTotal()>21){
                       System.out.println(player.getName() + " BUSTED. " + "\nHand total was " +player.getHandTotal());
                       turnOver = true;
                   }

                }while(!turnOver);



               // player.bet(30);
                //System.out.println("money: " + player.getMoney() + " bet: "+ player.getBet());
                //player.hitMe(deck.dealCard());
               // player.hitMe(deck.dealCard());

               System.out.println(player.getName());
                player.getHand().printHand();

                //player.hitMe(deck.dealCard());
                //player.bet(30);
                //System.out.println(player.getName());
                //player.getHand().printHand();
                //System.out.println("money: " + player.getMoney() + " bet: "+ player.getBet());

            }





        } while(false);



        //printPlayers();







        //displayDeck();

        /*for(int i=0; i<53;i++) {
            displayDeck();
            System.out.println( "\n\n"+   deck.dealCard() );
        }*/

    }

    private void init (int numOfPlayers){
        createPlayers(numOfPlayers);

        /*for(int i=0; i< 100; i++){
            dealCard();
        }*/

        //placeBet();
       // printPlayers();


    }
    public void displayDeck(){
        deck.printDeck();
    }

    private void printPlayers(){
        for(Player player: players){
            System.out.println(player);
        }
    }

    private void createPlayers(int numOfPlayers){
        for(int i = 0; i<numOfPlayers; i++){
            //creating default player

            players.add(new Player("player " + i, 300+(0*i)));
        }
    }
    public void removePlayer (Player player){
        players.remove(player);
    }
    public Card dealCard(){
        return deck.dealCard();
    }

    public boolean betChoice(Player player){
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch(choice){
            case "H":
                player.hitMe(dealCard());
                break;
            case "B":
                System.out.println("How much do you want to bet?");
                player.bet(scanner.nextInt());
                break;
            case "S":
            case "E":
                return true;

        }
        return false;

    }

}


