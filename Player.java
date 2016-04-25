package com.company;

/**
 * Created by vassili.holenev on 8.04.2016.
 */
public class Player extends Hand{
    String player;
    int playerHealth;

    public Player(String hand, int numberOfCards, String playerName) {
        super(hand);
        player = playerName;
        playerHealth = 10;
    }

    public String getPlayerName() {
        return player;
    }

    @Override
    public void populateHand(Deck deck) {
        super.populateHand(deck);
    }

    @Override
    public void checkCards() {
        System.out.println("Player " + player + " have");
        super.checkCards();

    }

    public int modifyHealth(int number){
        if(playerHealth > 0 && number < playerHealth){
            playerHealth -= number;
        }
        return playerHealth;
    }
}
