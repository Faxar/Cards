package com.company;

/**
 * Created by vassili.holenev on 8.04.2016.
 */
public class Player extends Hand{
    String playerName;
    int playerHealth;

    public Player(String hand, int numberOfCards, String playerName) {
        super(hand, numberOfCards);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void populateHand(Deck deck) {
        super.populateHand(deck);
    }

    @Override
    public void checkCards() {
        System.out.println("Player " + playerName + " have");
        super.checkCards();

    }
}
